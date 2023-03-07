package com.jyjays.mapper;

import com.jyjays.domain.Comment;
import com.jyjays.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<Comment> selectComment(int commentId);

    List<Comment> selectByUser(String commentator);

    int createComment(int commentId);

    int insertComment(CommentDto commentDto);

    int deleteComment(int commentId);
}
