package com.yltrcc.blog.model.domain;

public class QuestionCategory {

	private Long categoryId;

	private String categoryName;

	private String categoryUrl;

	private String categoryDescribe;

	private Integer isTop;

	private Integer upperCategoryId;

	private Integer isFinal;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryUrl() {
		return categoryUrl;
	}

	public void setCategoryUrl(String categoryUrl) {
		this.categoryUrl = categoryUrl;
	}

	public String getCategoryDescribe() {
		return categoryDescribe;
	}

	public void setCategoryDescribe(String categoryDescribe) {
		this.categoryDescribe = categoryDescribe;
	}

	public Integer getIsTop() {
		return isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	public Integer getUpperCategoryId() {
		return upperCategoryId;
	}

	public void setUpperCategoryId(Integer upperCategoryId) {
		this.upperCategoryId = upperCategoryId;
	}

	public Integer getIsFinal() {
		return isFinal;
	}

	public void setIsFinal(Integer isFinal) {
		this.isFinal = isFinal;
	}
}