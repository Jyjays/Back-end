package com.jyjays.service;

import com.jyjays.domain.Comment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CommentRedisService {

    public void addComment(Comment comment);

    public List<Object> getCommentsById(int id);

    public void deleteComment(int ArticleId,int CommentId);
}
