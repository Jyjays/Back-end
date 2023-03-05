package com.jyjays.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ArticleMsg {
    private String writer;
    @NotBlank(message = "题目不能为空")
    private String title;
}
