package com.yltrcc.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.yltrcc.blog.mapper.custom.QuestionsMapperCustom;
import com.yltrcc.blog.mapper.generator.QuestionMapper;
import com.yltrcc.blog.model.domain.*;
import com.yltrcc.blog.model.dto.ArchiveBo;
import com.yltrcc.blog.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Package: com.yltrcc.blog.service.impl
 * Date：2022-01-15
 * Time：15:37
 * Description：面试题库接口实现类
 *
 * @author yltrcc
 * @version 1.0
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionsMapperCustom questionsMapperCustom;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public void save(Question Question, Long[] tagsName, Long[] categorys) throws Exception {
        questionMapper.insert(Question);
        if (categorys != null) {
           /* Arrays.asList(categorys).stream().forEach(cate -> {
                ArticleCategory articleCategory = new ArticleCategory();
                articleCategory.setArticleId(article.getId());
                articleCategory.setCategoryId(cate);
                articleCategoryMapper.insert(articleCategory);
            });*/
        }
        if (tagsName != null) {
            /*Arrays.asList(tags).stream().forEach(tag -> {
                ArticleTag articleTag = new ArticleTag();
                articleTag.setArticleId(article.getId());
                articleTag.setTagId(tag);
                articleTagMapper.insert(articleTag);
            });*/
        }
    }

    @Override
    public List<QuestionsCustom> findAllQuestions(int status, String post) {
        return null;
    }

    @Override
    public PageInfo<QuestionsCustom> findPageQuestions(int page, int limit, QuestionsCustom QuestionsCustom) {
        return null;
    }

    @Override
    public Integer countByStatus(Integer status, String post) {
        return null;
    }


    @Override
    public Integer getCounts() {
        return questionsMapperCustom.getCounts();
    }

    @Override
    public void remove(int id) throws Exception {

    }

    @Override
    public void recycle(int id, Integer integer) throws Exception {

    }


    @Override
    public Question findByQuestionsId(Integer Questions_id) {
        return questionsMapperCustom.findByQuestionsId(Questions_id);
    }

    @Override
    public void update(Question Question, Long[] tags, Long[] categorys) throws Exception {

    }

    @Override
    public List<ArchiveBo> archives() {
        return null;
    }

    @Override
    public int findRepeatByUrl(String QuestionsUrl) {
        return 0;
    }

    @Override
    public QuestionsCustom findByQuestionsUrl(String QuestionsUrl) {
        return null;
    }

    @Override
    public PageInfo<QuestionsCustom> findArtileByCategory(int page, int limit, Category category, int status) {
        return null;
    }

    @Override
    public PageInfo<QuestionsCustom> findArtileByTag(Integer page, Integer limit, Tag tag, int status) {
        return null;
    }


    @Override
    public PageInfo<Question> findQuestionsByKeywords(String keywords, Integer page, Integer limit) {
        return null;
    }

    @Override
    public void updateQuestionsViews(Question Question) {

    }


}
