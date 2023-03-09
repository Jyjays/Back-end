package com.jyjays.service.impl;

import com.jyjays.domain.Comment;
import com.jyjays.service.CommentRedisService;
import com.jyjays.utils.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentRedisServiceImpl implements CommentRedisService {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public void addComment(Comment comment) {
        redisUtil.putHash("article:"+comment.getId(), String.valueOf(comment.getCommentId()),comment);
    }

    @Override
    public List<Object> getCommentsById(int id) {
        return redisUtil.getEntries("article:"+id);
    }

    @Override
    public void deleteComment(int ArticleId, int CommentId) {
        redisUtil.removeHash("article:"+ArticleId, String.valueOf(CommentId));
    }
}
