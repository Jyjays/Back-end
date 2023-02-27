package com.jyjays;

import cn.hutool.core.util.RandomUtil;
import com.jyjays.domain.User;
import com.jyjays.service.UserService;
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
    @Test
    public void testSelectUser(){
//        User user=new User(1,"jys","12345");
//        redisTemplate.opsForValue().set("user:100", user);
//        Object ob=redisTemplate.opsForValue().get("user:100");
//        System.out.println(ob);
        String n=RandomUtil.randomNumbers(4);
        System.out.println(n);
    }
    @Test
    public void testRegisterUser(){
        User user=new User(4, "xj", "666");
        User user1=userService.selectUserbyName(user.getUsername());
        if(user1==null){
            System.out.println("失败");
        }
        boolean flag=userService.insertUser(user);
        System.out.println("chengg");

        System.out.println(user1);
    }

}
