package com.jyjays.service;

import com.jyjays.domain.Article;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface ArticleService {

    public List<Article> selectArticlebyWriter(String writer);

    public List<Article> selectArticlebyTitle(String title);

    public Article selectArticlebyCondition(String writer,String title);

    public boolean saveArticle(Article article);

    public boolean updateArticle(Map<String,Object> map);

    public boolean deleteArticle(String writer,String title);

}
