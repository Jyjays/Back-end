package com.jyjays.mapper;

import com.jyjays.domain.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    List<Article> selectArticlebyWriter(String writer);

    List<Article> selectArticlebyTitle(String title);

    List<Article> selectArticlebyCondition(String writer ,String title);

    int saveArticle(Article article);

//    int updatArticle(Article article);

}
