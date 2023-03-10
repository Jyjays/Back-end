package com.jyjays.controller;

import com.jyjays.domain.Article;
import com.jyjays.domain.Comment;
import com.jyjays.domain.Like;
import com.jyjays.exception.BusinessException;
import com.jyjays.service.ArticleService;
import com.jyjays.service.CommentRedisService;
import com.jyjays.service.LikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@RestController
@Api(value = "用户文章")
@RequestMapping("/articles")
public class BlogController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectExceptionAdvice.class);



    @Resource
    private CommentRedisService commentRedisService;

    @Resource
    private LikeService likeService;

    @Resource
    private ArticleService articleService;


    @GetMapping("/{writer}/{title}")
    @ApiOperation(value = "查看文章")
    public ArticleResult openArticle(@PathVariable("writer") String writer, @PathVariable("title") String title) {
        try {
            Article article = articleService.selectArticlebyCondition(writer, title);
            if (article == null) {
                throw new BusinessException(Code.GET_ERR, "文章不存在");
            }

            Like like = likeService.selectLike(article.getCommentId());
            List<Object> list = commentRedisService.getCommentsById(article.getCommentId());

            if (list == null || list.isEmpty()) {
                throw new BusinessException(Code.GET_ERR, "评论不存在");
            }

            return new ArticleResult(article, list, like, Code.GET_OK, "查询成功");
        } catch (BusinessException ex) {
            return new ArticleResult(null, ex.getCode(), ex.getMessage());
        } catch (Exception ex) {
            logger.error("An error occurred while retrieving article", ex);
            return new ArticleResult(null, Code.SYSTEM_UNKNOW_ERR, "系统繁忙，请稍后再试！");
        }
    }

    @GetMapping("/{articleId}/comments")
    @ApiOperation(value = "查看评论")
    public Result checkComment(@PathVariable("articleId") int articleId){
        List<Object> list = commentRedisService.getCommentsById(articleId);
        return new Result(list,Code.GET_OK,"查询成功");
    }

    @PostMapping("/{articleId}/comments")
    @ApiOperation(value = "添加评论")
    public Result addComment(@PathVariable("articleId") int articleId, @RequestBody Comment comment) {
        comment.setId(articleId);
        commentRedisService.addComment(comment);
        return new Result(Code.SAVE_OK, "评论成功");
    }

    @PostMapping("/{articleId}/like")
    @ApiOperation(value = "点赞")
    public Result StarArticle(@PathVariable("articleId") int articleId){
        boolean flag =likeService.increaseLike(articleId);
        return new Result(flag? Code.UPDATE_OK:Code.UPDATE_ERR,flag? "点赞成功":"点赞失败");
    }
}

