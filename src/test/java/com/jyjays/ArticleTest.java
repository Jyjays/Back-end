package com.jyjays;

import com.jyjays.controller.Code;
import com.jyjays.controller.Result;
import com.jyjays.domain.Article;
import com.jyjays.domain.User;
import com.jyjays.dto.ArticleDto;
import com.jyjays.dto.ArticleMsg;
import com.jyjays.dto.ArticleUpd;
import com.jyjays.dto.LikeDto;
import com.jyjays.service.ArticleService;
import com.jyjays.service.LikeService;
import com.jyjays.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ArticleTest {


    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;


    @Test
    public void testPost() {
        Article article = new Article(0, "xj", "923874949823", "铜山中专", 12343);
        User user = userService.selectUserbyName(article.getWriter());
        Article article1=articleService.selectArticlebyCondition(article.getWriter(),
                article.getTitle());
        System.out.println(article1);
    }

    @Test
    public void testSelectFuzzy(){
        List<Article> article= articleService.selectFuzzy("xj", 0);
        System.out.println(article);
    }

    @Test
    public void testUpdateArticle(){
        ArticleUpd articleUpd=new ArticleUpd();
        articleUpd.setArticle("987");
        articleUpd.setTitle(" ");
        articleUpd.setChangedTitle("tongshan");
        articleUpd.setWriter("xj");
        System.out.println(articleService.updateArticle(articleUpd));
    }


}
