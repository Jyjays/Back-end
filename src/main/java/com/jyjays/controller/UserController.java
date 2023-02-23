package com.jyjays.controller;

import com.jyjays.domain.User;
import com.jyjays.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/{username}/{password}")
    @GetMapping
    public Result selectUser(@PathVariable String username,@PathVariable String password){
        User user1=userService.selectUserWithoutId(username,password);
        if(user1.getId()==0){
            return new Result(Code.GET_ERR,user1.getId());
        }
        return new Result(Code.GET_OK,"登陆成功");
    }

    @PostMapping
    public Result Register(@RequestBody User user){
        User user1=userService.selectUserbyName(user.getUsername());
        if(user1!=null){
            return new Result(Code.SAVE_ERR,"用户已存在");
        }
        boolean flag=userService.insertUser(user);
        return new Result(userService.selectUser(user),flag? Code.SAVE_OK:Code.SAVE_ERR,flag? "注册成功":"注册失败");
    }


    @PutMapping
    public Result Update(@RequestBody User user,@RequestParam Map<String ,String> map){
        User user1=userService.selectUser(user);
       if(user1!=null){
           boolean flag=userService.updateUserPassword(map);
           return new Result(userService.selectUserbyMap(map),flag? Code.UPDATE_OK:Code.SAVE_ERR,flag?"修改成功":"修改失败");
       }else {
           return new Result(Code.GET_ERR,"账号或密码错误");
       }
    }

    @DeleteMapping
    public Result Delete(@RequestBody User user){
        User user1=userService.selectUser(user);
        System.out.println(user1);
        if(user1!=null){
            boolean flag=userService.deleteUser(user);
            return new Result(user1,flag? Code.DELETE_OK:Code.DELETE_ERR,flag?"删除成功":"删除失败");
        }else {
            return new Result(Code.GET_ERR,"账号或密码错误");
        }
    }



}