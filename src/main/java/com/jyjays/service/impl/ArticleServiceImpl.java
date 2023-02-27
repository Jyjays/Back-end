package com.jyjays.service.impl;

import com.jyjays.domain.Article;
import com.jyjays.mapper.ArticleMapper;
import com.jyjays.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper;

    @Override
    public List<Article> selectArticlebyWriter(String writer) {
        return null;
    }

    @Override
    public List<Article> selectArticlebyTitle(String title) {
        return null;
    }

    @Override
    public Article selectArticlebyCondition(String writer, String title) {
        return null;
    }

    @Override
    public boolean saveArticle(Article article) {
        return false;
    }

    @Override
    public boolean updateArticle(Map<String, Object> map) {
        return false;
    }

    @Override
    public boolean deleteArticle(String writer, String title) {
        return false;
    }
}
