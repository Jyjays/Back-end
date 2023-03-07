package com.jyjays.service;

import com.jyjays.domain.Comment;
import com.jyjays.dto.CommentDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CommentService {
    List<Comment> selectComment(int commentId);

    List<Comment> selectByUser(String commentator);

    boolean createComment(int commentId);

    boolean insertComment(CommentDto commentDto);

    boolean deleteComment(int commentId);
}
