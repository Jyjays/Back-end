package com.jyjays.service;

import com.jyjays.domain.Article;
import com.jyjays.dto.ArticleDto;
import com.jyjays.dto.ArticleMsg;
import com.jyjays.dto.ArticleUpd;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ArticleService {

    public List<Article> selectAll(int page);

    public List<Article> selectArticlebyWriter(String writer);

    public List<Article> selectArticlebyTitle(String title);

    public Article selectArticlebyCondition(String writer,String title);

    public List<Article> selectFuzzy(String msg,int page);


    public boolean saveArticle(Article article);

    public boolean updateArticle(ArticleUpd articleUpd);

    public boolean deleteArticle(ArticleMsg articleMsg);

}
