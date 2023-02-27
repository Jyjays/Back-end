package com.jyjays.mapper;

import com.jyjays.domain.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper {

    List<Article> selectArticlebyWriter(String writer);

    List<Article> selectArticlebyTitle(String title);

    List<Article> selectArticlebyCondition(String writer ,String title);

    int saveArticle(Article article);

    int updatArticle(Map<String,Object> map);

    int deleteArticle(String writer ,String title);

}
