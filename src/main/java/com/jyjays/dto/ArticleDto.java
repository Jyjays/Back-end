package com.jyjays.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ArticleDto {
    private String writer;

    private String article;

    private String title;
}
