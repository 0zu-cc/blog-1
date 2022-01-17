package com.yltrcc.blog.api.dto;

/**
 * Package: com.yltrcc.blog.api.dto
 * Date：2022-01-17
 * Time：15:47
 * Description：TODO
 *
 * @author yltrcc
 * @version 1.0
 */
public class QbankDto {

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章内容markdown格式
     */
    private String articleContentMd;

    /**
     * 文章摘要
     */
    private String articleSummary;

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContentMd() {
        return articleContentMd;
    }

    public void setArticleContentMd(String articleContentMd) {
        this.articleContentMd = articleContentMd;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }
}
