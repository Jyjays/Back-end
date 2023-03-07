package com.jyjays.dto;

import lombok.Data;

@Data
public class ArticleUpd {
    private String writer;
    private String article;

    private String changedTitle;

    private String title;
}
