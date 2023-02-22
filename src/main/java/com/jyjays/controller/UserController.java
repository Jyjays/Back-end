package com.jyjays.controller;

import com.jyjays.domain.User;
import com.jyjays.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController

public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login/{username}/{password}")
    @GetMapping
    public Result selectUser(@PathVariable String username,@PathVariable String password){
        User user1=userService.selectUserWithoutId(username,password);
        if(user1.getId()==0){
            return new Result(Code.GET_ERR,user1.getId());
        }
        return new Result(Code.GET_OK,"登陆成功");
    }
    @RequestMapping("/register")
    @PostMapping
    public Result Register(@RequestBody User user){
        User user1=userService.selectUserbyName(user.getUsername());
        if(user1!=null){
            return new Result(Code.SAVE_ERR,"用户已存在");
        }
        boolean flag=userService.insertUser(user);
        return new Result(userService.selectUser(user),flag? Code.SAVE_OK:Code.SAVE_ERR,flag? "注册成功":"注册失败");
    }


}