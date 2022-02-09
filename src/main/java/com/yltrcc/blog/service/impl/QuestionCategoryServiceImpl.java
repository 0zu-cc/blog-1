package com.yltrcc.blog.service.impl;

import com.yltrcc.blog.mapper.generator.CategoryMapper;
import com.yltrcc.blog.mapper.generator.QuestionCategoryMapper;
import com.yltrcc.blog.model.domain.*;
import com.yltrcc.blog.service.CategoryService;
import com.yltrcc.blog.service.QuestionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yltrcc
 * @createDate : 2018年9月26日
 *
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class QuestionCategoryServiceImpl implements QuestionCategoryService {
	private static final String CATEGORYS_CACHE_KEY = "'QuestionCategory'";
	private static final String CATEGORYS_CACHE_NAME = "questionCategories";

	@Autowired
	private CategoryMapper categoryMapper;
	@Resource
	private QuestionCategoryMapper questionCategoryMapper;

	@Override
	//@Cacheable(value = CATEGORYS_CACHE_NAME, key = CATEGORYS_CACHE_KEY)
	public List<QuestionCategory> findCategory() {
		QuestionCategoryExample example = new QuestionCategoryExample();
		QuestionCategoryExample.Criteria questionCategoryCriteria = example.createCriteria();
		questionCategoryCriteria.andIsFinalEqualTo(1);
		example.setOrderByClause(" concat(upper_category_id,category_id) asc");
		return questionCategoryMapper.selectByExample(example);
	}

	@Override
	public Category findByCategoryId(int categoryId) {
		return categoryMapper.selectByPrimaryKey(categoryId);
	}

	@Override
	@CacheEvict(value = CATEGORYS_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void save(Category category) throws Exception {
		categoryMapper.insert(category);
	}

	@Override
	@CacheEvict(value = CATEGORYS_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void update(Category category) throws Exception {
		categoryMapper.updateByPrimaryKeySelective(category);
	}

	@Override
	@CacheEvict(value = CATEGORYS_CACHE_NAME, allEntries = true, beforeInvocation = true)
	public void delete(int categoryId) throws Exception {
		categoryMapper.deleteByPrimaryKey(categoryId);
	}

	@Override
	public Category findByCateUrl(String cateUrl) {
		CategoryExample categoryExample = new CategoryExample();
		CategoryExample.Criteria criteria = categoryExample.createCriteria();
		criteria.andCategoryUrlEqualTo(cateUrl);
		return categoryMapper.selectByExample(categoryExample).get(0);
	}

}
