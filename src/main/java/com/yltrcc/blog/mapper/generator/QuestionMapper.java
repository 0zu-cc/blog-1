package com.yltrcc.blog.mapper.generator;

import com.yltrcc.blog.model.domain.Article;
import com.yltrcc.blog.model.domain.ArticleExample;
import com.yltrcc.blog.model.domain.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {


	int insert(Question record);

}