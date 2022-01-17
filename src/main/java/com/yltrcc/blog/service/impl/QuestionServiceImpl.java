package com.yltrcc.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yltrcc.blog.mapper.custom.CategoryMapperCustom;
import com.yltrcc.blog.mapper.custom.QuestionMapperCustom;
import com.yltrcc.blog.mapper.custom.TagMapperCustom;
import com.yltrcc.blog.mapper.generator.QuestionMapper;
import com.yltrcc.blog.model.domain.*;
import com.yltrcc.blog.model.dto.ArchiveBo;
import com.yltrcc.blog.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    private QuestionMapperCustom questionMapperCustom;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private TagMapperCustom tagMapperCustom;

    @Autowired
    private CategoryMapperCustom categoryMapperCustom;

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
    public List<QuestionCustom> findAllQuestion(int status, String post) {
        return null;
    }

    @Override
    public PageInfo<QuestionCustom> findPageQuestion(int page, int limit, QuestionCustom questionCustom) {
        PageHelper.startPage(page, limit);
        List<QuestionCustom> lists = questionMapperCustom.findPageQuestion(questionCustom);
        return new PageInfo<>(lists);
    }

    @Override
    public Integer countByStatus(Integer status, String post) {
        return null;
    }


    @Override
    public Integer getCounts() {
        return questionMapperCustom.getCounts();
    }

    @Override
    public void remove(int id) throws Exception {

    }

    @Override
    public void recycle(int id, Integer integer) throws Exception {

    }


    @Override
    public QuestionCustom findByQuestionId(Integer questionId) {
        return questionMapperCustom.findByQuestionId(questionId);
    }

    @Override
    public void update(Question question, Long[] tags, Long[] categorys) throws Exception {
        // 修改文章
        questionMapper.updateByPrimaryKeySelective(question);
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
    public QuestionCustom findByQuestionsUrl(String QuestionsUrl) {
        return null;
    }

    @Override
    public PageInfo<QuestionCustom> findArtileByCategory(int page, int limit, Category category, int status) {
        return null;
    }

    @Override
    public PageInfo<QuestionCustom> findArtileByTag(Integer page, Integer limit, Tag tag, int status) {
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
