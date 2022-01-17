package com.yltrcc.blog.mapper.generator;

import com.yltrcc.blog.model.domain.Article;
import com.yltrcc.blog.model.domain.ArticleExample;
import com.yltrcc.blog.model.domain.Question;
import com.yltrcc.blog.model.domain.QuestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {
	long countByExample(ArticleExample example);

	int deleteByExample(ArticleExample example);

	int deleteByPrimaryKey(Integer id);

	int insertSelective(Question record);

	List<Question> selectByExample(QuestionExample example);

	Question selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

	int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

	int updateByPrimaryKeySelective(Question record);

	int updateByPrimaryKey(Question record);

	int insert(Question record);

}