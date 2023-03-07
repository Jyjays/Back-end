package com.jyjays.service.impl;

import com.jyjays.domain.Comment;
import com.jyjays.dto.CommentDto;
import com.jyjays.mapper.CommentMapper;
import com.jyjays.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> selectComment(int commentId) {
        return commentMapper.selectComment(commentId);
    }

    @Override
    public List<Comment> selectByUser(String commentator) {
        return commentMapper.selectByUser(commentator);
    }

    @Override
    public boolean createComment(int commentId) {
        return commentMapper.createComment(commentId)>0;
    }

    @Override
    public boolean insertComment(CommentDto commentDto) {
        return commentMapper.insertComment(commentDto)>0;
    }

    @Override
    public boolean deleteComment(int commentId) {
        return commentMapper.deleteComment(commentId)>0;
    }
}
