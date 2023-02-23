package com.jyjays.domain;

public class Article {
    private int userId;
    private String writer;
    private String article;
    private String title;

    private  int commentId;

    public Article() {
    }

    public Article(int userId, String writer, String article, String title, int commentId) {
        this.userId = userId;
        this.writer = writer;
        this.article = article;
        this.title = title;
        this.commentId = commentId;
    }

    /**
     * 获取
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return writer
     */
    public String getWriter() {
        return writer;
    }

    /**
     * 设置
     * @param writer
     */
    public void setWriter(String writer) {
        this.writer = writer;
    }

    /**
     * 获取
     * @return article
     */
    public String getArticle() {
        return article;
    }

    /**
     * 设置
     * @param article
     */
    public void setArticle(String article) {
        this.article = article;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return commentId
     */
    public int getCommentId() {
        return commentId;
    }

    /**
     * 设置
     * @param commentId
     */
    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String toString() {
        return "Article{userId = " + userId + ", writer = " + writer + ", article = " + article + ", title = " + title + ", commentId = " + commentId + "}";
    }
}
