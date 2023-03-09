package com.jyjays.controller;

import com.jyjays.domain.Article;
import com.jyjays.domain.Comment;
import com.jyjays.domain.User;
import com.jyjays.dto.ArticleDto;
import com.jyjays.dto.ArticleMsg;
import com.jyjays.dto.ArticleUpd;
import com.jyjays.dto.LikeDto;
import com.jyjays.service.*;
import com.jyjays.utils.JwtUtils;
import com.jyjays.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "博客")
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @Resource
    private UserService userService;

    @Resource
    private LikeService likeService;

    @Resource
    private CommentService commentService;

    @Resource
    private JwtUtils jwtUtils;

    @Resource
    private CommentRedisService commentRedisService;


    @GetMapping("/allArticle/{page}")
    @ApiOperation(value = "查看所有")
    public Result getAll(@PathVariable int page){
        try {
            return new Result(articleService.selectAll(page), Code.GET_OK, "查询成功");
        }catch (Exception e){
            return new Result(Code.GET_ERR,"查询失败");
        }
    }

    @GetMapping("/sel/{msg}/{page}")
    @ApiOperation(value = "搜索博客")
    public Result selectArticle(@PathVariable String msg, @PathVariable int page){
            return new Result(articleService.selectFuzzy(msg, page), Code.GET_OK, "查询成功");

    }



    @PostMapping("/p")
    @ApiOperation(value = "上传博客")
    public Result saveArticle(@RequestBody Article article){
        User user = userService.selectUserbyName(article.getWriter());
        Article article1=articleService.selectArticlebyCondition(article.getWriter(),
                article.getTitle());
        if(user==null){
            return new Result(article, Code.GET_ERR, "用户名输入错误");
        }
        if(article1!=null){
            return new Result(article,Code.SAVE_ERR,"用户已拥有一篇同名文章");
        }
        article.setUserId(user.getId());
        LikeDto likeDto=new LikeDto(article.getCommentId(),0);
        boolean flag=articleService.saveArticle(article);
        likeService.setlike(likeDto);
        commentService.createComment(article.getCommentId());
        return new Result(article,flag? Code.SAVE_OK:Code.SAVE_ERR,flag? "保存成功":"保存失败");
    }

    @PutMapping("/u")
    @ApiOperation(value = "修改博客")
    public Result updateArticle(@RequestBody ArticleUpd articleUpd) {
        boolean flag = articleService.updateArticle(articleUpd);
        return new Result(articleUpd, flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag ? "更新成功" : "更新失败");
    }


    @DeleteMapping("/d")
    @Transactional
    @ApiOperation(value = "删除文章")
    public Result deleteArticle(@RequestBody ArticleMsg articleMsg){
        Article article=articleService.selectArticlebyCondition(articleMsg.getWriter(), articleMsg.getTitle());
        boolean flag = articleService.deleteArticle(articleMsg)
                && likeService.deleteLike(article.getCommentId());
        return new Result(flag? Code.DELETE_OK:Code.DELETE_ERR,flag? "删除成功":"删除失败");
    }
}
