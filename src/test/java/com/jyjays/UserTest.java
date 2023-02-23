package com.jyjays;

import com.jyjays.controller.Code;
import com.jyjays.controller.Result;
import com.jyjays.domain.User;
import com.jyjays.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;
    @Test
    public void testSelectUser(){
        User user=new User(1,"jys","12345");
        System.out.println(userService.selectUser(user));
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
