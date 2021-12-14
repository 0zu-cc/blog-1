package com.yltrcc.blog.service.impl;

import java.util.List;

import com.yltrcc.blog.mapper.generator.CategoryMapper;
import com.yltrcc.blog.model.domain.Category;
import com.yltrcc.blog.model.domain.CategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yltrcc.blog.service.CategoryService;

/**
 * @author yltrcc
 * @createDate : 2018年9月26日
 *
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class CategoryServiceImpl implements CategoryService {
	private static final String CATEGORYS_CACHE_KEY = "'category'";
	private static final String CATEGORYS_CACHE_NAME = "categorys";

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	@Cacheable(value = CATEGORYS_CACHE_NAME, key = CATEGORYS_CACHE_KEY)
	public List<Category> findCategory() {
		return categoryMapper.selectByExample(null);
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
