package com.jyjays;

import com.jyjays.domain.Comment;
import com.jyjays.domain.Like;
import com.jyjays.service.CommentRedisService;
import com.jyjays.service.LikeService;
import com.jyjays.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest

public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired(required = false)
    private LikeService likeService;

    @Autowired
    private CommentRedisService commentRedisService;

    @Test
    public void testComment(){
        Date date=new Date();
        date.getTime();
        Comment comment=new Comment(1,"xj","6hiuh",66,date);
        commentRedisService.addComment(comment);
        System.out.println(commentRedisService.getCommentsById(1));
//        System.out.println(redisUtil.getEntries("article"+1));
        System.out.println(likeService.selectLike(1));
    }
}
