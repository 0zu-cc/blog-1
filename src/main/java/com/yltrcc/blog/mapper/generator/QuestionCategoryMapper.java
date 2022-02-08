package com.yltrcc.blog.mapper.generator;

import com.yltrcc.blog.model.domain.Category;
import com.yltrcc.blog.model.domain.CategoryExample;
import com.yltrcc.blog.model.domain.QuestionCategory;
import com.yltrcc.blog.model.domain.QuestionCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionCategoryMapper {
	long countByExample(CategoryExample example);

	int deleteByExample(CategoryExample example);

	int deleteByPrimaryKey(Integer categoryId);

	int insert(Category record);

	int insertSelective(Category record);

	List<QuestionCategory> selectByExample(QuestionCategoryExample example);

	Category selectByPrimaryKey(Integer categoryId);

	int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

	int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

	int updateByPrimaryKeySelective(Category record);

	int updateByPrimaryKey(Category record);
}