package com.jyjays.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CommentDto {
    @NotBlank(message = "用户Id不能为空")
    private int id;
    @NotBlank(message = "用户名不能为空")
    private String commentator;
    @NotBlank(message = "不能发表空白评论")
    private String comment;
}
