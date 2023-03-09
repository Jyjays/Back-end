package com.jyjays.domain;

import java.util.Date;

public class Comment {
    private int id;
    private String commentator;
    private String comment;

    private int commentId;
    private Date createDate;

    public Comment() {
    }

    public Comment(int id, String commentator, String comment, int commentId, Date createDate) {
        this.id = id;
        this.commentator = commentator;
        this.comment = comment;
        this.commentId = commentId;
        this.createDate = createDate;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return commentator
     */
    public String getCommentator() {
        return commentator;
    }

    /**
     * 设置
     * @param commentator
     */
    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    /**
     * 获取
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
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

    /**
     * 获取
     * @return createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String toString() {
        return "Comment{id = " + id + ", commentator = " + commentator + ", comment = " + comment + ", commentId = " + commentId + ", createDate = " + createDate + "}";
    }
}
