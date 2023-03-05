package com.jyjays.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ArticleDto {
    private String writer;
    private String article;
    @NotBlank(message = "题目不能为空")
    private String title;
}
