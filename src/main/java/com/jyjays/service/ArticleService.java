package com.jyjays.service;

import com.jyjays.domain.Article;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ArticleService {

    public List<Article> selectArticlebyWriter(String writer);

    public List<Article> selectArticlebyTitle(String title);

    public Article selectArticlebyCondition(String writer,String title);

    public int saveArticle(Article article);

}
