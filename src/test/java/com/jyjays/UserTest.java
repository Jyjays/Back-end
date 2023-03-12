package com.jyjays;

import com.jyjays.domain.User;
import com.jyjays.service.LikeService;
import com.jyjays.service.UserService;
import com.jyjays.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired(required = false)
    private LikeService likeService;

    @Autowired
    private JwtUtils jwtUtils;
//    @Test
//    public void testSelectUser(){
//
//        Object ob=redisTemplate.opsForValue().get("user:100");
//        System.out.println(ob);
//        String n=RandomUtil.randomNumbers(4);
//        System.out.println(n);
//    }
//    @Test
//    public void testRegisterUser(){
//        User user=new User(4, "xj", "666");
//        User user1=userService.selectUserbyName(user.getUsername());
//        if(user1==null){
//            System.out.println("失败");
//        }
//
//        System.out.println("chengg");
//
//        System.out.println(user1);
//    }

    @Test
    public void testFilter() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ4aiIsImlhdCI6MTY3NzkxMTAwNiwiZXhwIjoxNjc3OTE3MDA2fQ.63Z2FG39lnHnYqShCTNC7bs8-sto2reEmcW1tDvIWG7aMgCTxa2RkY0ayOcqmUvwySfIdMlC9vXALPgGryM6_A";
        String username=jwtUtils.getUsernameFromToken(token);
        if (redisTemplate.opsForValue().get(username)==token){
            System.out.println("666");
        }
        System.out.println(username);
    }

    @Test
    public void testLike(){
        likeService.deleteLike(23);
    }


    @Test
    public void testRegister(){
        User user=new User(0, " ", "  ","3 ");
        userService.insertUser(user);
        System.out.println(userService.selectUserbyName(user.getUsername()) );
    }
}
