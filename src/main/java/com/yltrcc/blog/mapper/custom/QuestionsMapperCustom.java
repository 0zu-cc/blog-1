package com.yltrcc.blog.mapper.custom;

import com.yltrcc.blog.model.domain.*;
import com.yltrcc.blog.model.dto.ArchiveBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yltrcc
 * @createDate : 2018年11月1日
 */
public interface QuestionsMapperCustom {

	List<QuestionsCustom> questionsMapperCustom(@Param(value = "status") int status);

	List<QuestionsCustom> findAllQuestions(@Param(value = "status") int status, @Param(value = "post") String post);

	Integer countByStatus(@Param(value = "status") Integer status, @Param(value = "post") String post);

	void updateStatus(@Param(value = "id") int id, @Param(value = "status") int status);

	Question findByQuestionsId(@Param(value = "id") Integer questions_id);

	List<ArchiveBo> findDateAndCount();

	List<QuestionsCustom> findPageQuestions(QuestionsCustom questionsCustom);

	int findRepeatByUrl(@Param(value = "questionsUrl") String questionsUrl);

	QuestionsCustom findByQuestionsUrl(@Param(value = "questionsUrl") String questionsUrl);

	List<QuestionsCustom> findArtileByCategory(@Param("category") Category category, @Param(value="status") int status);

	List<QuestionsCustom> findArtileByTag(@Param("tag") Tag tag, @Param(value="status") int status);

	Integer getCounts();
}
