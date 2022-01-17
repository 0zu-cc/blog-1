package com.yltrcc.blog.service;

import com.github.pagehelper.PageInfo;
import com.yltrcc.blog.model.domain.Question;
import com.yltrcc.blog.model.domain.QuestionsCustom;
import com.yltrcc.blog.model.domain.Category;
import com.yltrcc.blog.model.domain.Tag;
import com.yltrcc.blog.model.dto.ArchiveBo;

import java.util.List;

/**
 * Package: com.yltrcc.blog.service
 * Date：2022-01-15
 * Time：15:36
 * Description：面试题库接口
 *
 * @author yltrcc
 * @version 1.0
 */
public interface QuestionService {

    /**
     * 保存题库
     *
     * @param Question
     *            题库
     * @param tagsName
     *            标签id
     * @param categorys
     *            分类id
     */
    void save(Question Question, Long[] tagsName, Long[] categorys) throws Exception;

    /**
     * 不分页查询所有题库
     *
     * @param status
     * @param string
     * @return
     */
    List<QuestionsCustom> findAllQuestions(int status, String post);

    /**
     * 分页查询所有题库
     *
     * @param limit
     * @param page
     * @param QuestionsCustom
     *            题库对象
     * @return
     */
    PageInfo<QuestionsCustom> findPageQuestions(int page, int limit, QuestionsCustom QuestionsCustom);

    /**
     * 状态统计条数
     *
     * @param status
     *            状态
     * @param post
     *            类型
     * @return
     */
    Integer countByStatus(Integer status, String post);

    /**
     * 统计数据库表记录总数
     * @return
     */
    Integer getCounts();

    /**
     * 修改题库状态为回收站
     *
     * @param id
     */
    void remove(int id) throws Exception;

    /**
     * 修改题库状态为回收站
     *
     * @param id
     * @param integer
     */
    void recycle(int id, Integer integer) throws Exception;

    /**
     * id查询题库
     *
     * @param Questions_id
     * @return
     */
    Question findByQuestionsId(Integer Questions_id);

    /**
     * 修改题库
     *
     * @param Question
     * @param tags
     *            标签id
     * @param categorys
     *            分类id
     * @throws Exception
     */
    void update(Question Question, Long[] tags, Long[] categorys) throws Exception;

    /**
     * 归档
     *
     * @return
     */
    List<ArchiveBo> archives();

    /**
     * 统计重复链接
     *
     * @param QuestionsUrl
     *            题库链接
     * @return
     */
    int findRepeatByUrl(String QuestionsUrl);

    /**
     * 题库链接查询
     *
     * @param QuestionsUrl
     * @return 题库
     */
    QuestionsCustom findByQuestionsUrl(String QuestionsUrl);

    /**
     * 分页查询分类下的所有题库
     *
     * @param page
     * @param limit
     * @param category
     * @param status 题库状态
     * @return
     */
    PageInfo<QuestionsCustom> findArtileByCategory(int page, int limit, Category category, int status);

    /**
     * 分页查询标签下的所有题库
     *
     * @param page
     * @param size
     * @param tag
     * @param status 题库状态
     * @return
     */
    PageInfo<QuestionsCustom> findArtileByTag(Integer page, Integer limit, Tag tag, int status);

    /**
     * 标题分页搜索题库
     *
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    PageInfo<Question> findQuestionsByKeywords(String keywords, Integer page, Integer limit);
    /**
     * 修改题库点击数
     * @param Question
     */
    void updateQuestionsViews(Question Question);
    
}
