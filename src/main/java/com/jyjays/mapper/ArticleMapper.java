package com.jyjays.mapper;

import com.jyjays.domain.Article;
import com.jyjays.dto.ArticleDto;
import com.jyjays.dto.ArticleMsg;
import com.jyjays.dto.ArticleUpd;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper {

    List<Article> selectArticlebyWriter(String writer);

    List<Article> selectArticlebyTitle(String title);

    Article selectArticlebyCondition(String writer,String title);

    List<Article> selectFuzzy(String msg,int page);

    List<Article> selectAll(int page);

    int saveArticle(Article article);

    int updateArticle(ArticleUpd articleUpd);

    int updateWriter(int userId,String writer);

    int deleteArticle(ArticleMsg articleMsg);

}
