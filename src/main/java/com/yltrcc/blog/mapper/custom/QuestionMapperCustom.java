package com.yltrcc.blog.mapper.custom;

import com.yltrcc.blog.model.domain.*;
import com.yltrcc.blog.model.dto.ArchiveBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yltrcc
 * @createDate : 2018年11月1日
 */
public interface QuestionMapperCustom {

	List<QuestionCustom> questionsMapperCustom(@Param(value = "status") int status);

	List<QuestionCustom> findAllQuestion(@Param(value = "status") int status, @Param(value = "post") String post);

	Integer countByStatus(@Param(value = "status") Integer status, @Param(value = "post") String post);

	void updateStatus(@Param(value = "id") int id, @Param(value = "status") int status);

	QuestionCustom findByQuestionId(@Param(value = "id") Integer questionId);

	List<ArchiveBo> findDateAndCount();

	List<QuestionCustom> findPageQuestion(QuestionCustom questionsCustom);

	int findRepeatByUrl(@Param(value = "questionsUrl") String questionsUrl);

	QuestionCustom findByQuestionsUrl(@Param(value = "questionsUrl") String questionsUrl);

	List<QuestionCustom> findArtileByCategory(@Param("category") Category category, @Param(value="status") int status);

	List<QuestionCustom> findArtileByTag(@Param("tag") Tag tag, @Param(value="status") int status);

	Integer getCounts();
}
