package com.jyjays.domain;

public class Comment {
    private int id;
    private String commentator;
    private String comment;

    public Comment() {
    }

    public Comment(int id, String commentator, String comment) {
        this.id = id;
        this.commentator = commentator;
        this.comment = comment;
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
     * @return Comment
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

    public String toString() {
        return "Comment{id = " + id + ", commentator = " + commentator + ", Comment = " + comment + "}";
    }
}
