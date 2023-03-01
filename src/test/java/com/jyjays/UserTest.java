package com.jyjays;

import cn.hutool.core.util.RandomUtil;
import com.jyjays.domain.User;
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
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqeWpheXMiLCJpYXQiOjE2Nzc2NTYxMDcsImV4cCI6MTY3NzY2MjEwN30.rQ5jIYf_PvgIhIt_mDpPXuuNR83qMn5Fi96UuK8iRJG5shsIyxxQIQq4sda8gF6eQLAdtXbbhWN7Ccp9En2Ufg";
        String username=jwtUtils.getUsernameFromToken(token);
        System.out.println(username);
    }
}
