package com.jyjays.service.impl;
import com.jyjays.domain.Article;
import com.jyjays.dto.ArticleDto;
import com.jyjays.dto.ArticleMsg;
import com.jyjays.mapper.ArticleMapper;
import com.jyjays.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<Article> selectAll(int page) {
        return articleMapper.selectAll(page);
    }

    @Override
    public List<Article> selectArticlebyWriter(String writer) {
        return articleMapper.selectArticlebyWriter(writer);
    }

    @Override
    public List<Article> selectArticlebyTitle(String title) {
        return articleMapper.selectArticlebyTitle(title);
    }

    @Override
    public Article selectArticlebyCondition(String writer, String title) {
        return articleMapper.selectArticlebyCondition(writer, title);
    }

    @Override
    public List<Article> selectFuzzy(String msg,int page) {
        return articleMapper.selectFuzzy(msg, page);
    }

    @Override
    public boolean saveArticle(Article article) {
        return articleMapper.saveArticle(article)>0;
    }

    @Override
    public boolean updateArticle(ArticleDto articleDto) {
        return articleMapper.updatArticle(articleDto)>0;
    }

    @Override
    public boolean deleteArticle(ArticleMsg articleMsg) {
        return articleMapper.deleteArticle(articleMsg)>0;
    }
}
