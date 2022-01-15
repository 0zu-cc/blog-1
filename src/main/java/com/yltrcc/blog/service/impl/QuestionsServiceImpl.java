package com.yltrcc.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yltrcc.blog.mapper.custom.QuestionsMapperCustom;
import com.yltrcc.blog.mapper.custom.CategoryMapperCustom;
import com.yltrcc.blog.mapper.custom.TagMapperCustom;
import com.yltrcc.blog.model.domain.*;
import com.yltrcc.blog.model.dto.ArchiveBo;
import com.yltrcc.blog.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsMapperCustom questionsMapperCustom;


    @Override
    public void save(Question Question, Long[] tagsName, Long[] categorys) throws Exception {

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
