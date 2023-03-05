package com.jyjays.controller;

import com.jyjays.domain.User;
import com.jyjays.dto.LoginDto;
import com.jyjays.dto.RegisterDto;
import com.jyjays.service.UserService;
import com.jyjays.utils.JwtUtils;
import com.jyjays.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;


@RestController
@Api(tags="登录注册")
@RequestMapping("/User")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private JwtUtils jwtUtils;

    @ApiOperation(value = "用户登录" )
    @GetMapping("/login")
    public Result selectUser(@RequestBody LoginDto loginDto){
        User user1=userService.selectUser(loginDto);
        if(user1.getId()==0){
            return new Result(Code.GET_ERR,user1.getId());
        }
        String token= jwtUtils.generateToken(loginDto.getUsername());
        redisUtil.set(loginDto.getUsername(), token);
        return new Result(token,Code.GET_OK,"登陆成功");
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/2")
    public Result Register(@RequestBody RegisterDto registerDto){

        User user1=userService.selectUserbyName(registerDto.getUsername());
        if(user1!=null){
            return new Result(Code.SAVE_ERR,"用户已存在");
        }
        String token= jwtUtils.generateToken(registerDto.getUsername());
        User user=new User(0,registerDto.getUsername(),registerDto.getPassword(),registerDto.getPhone());
        boolean flag=userService.insertUser(user);
        redisUtil.set(user.getUsername(), token);
        return new Result(token,flag? Code.SAVE_OK:Code.SAVE_ERR,flag? "注册成功":"注册失败");
    }


    @ApiOperation(value = "修改用户信息")
    @PutMapping("/3")
    public Result Update(@RequestBody LoginDto loginDto,@RequestParam Map<String ,Object> map){
        User user=userService.selectUser(loginDto);
        System.out.println(map.get("username"));
        map.put("id", user.getId());
        boolean flag=userService.updateUserPassword(map);
        return new Result(flag? Code.UPDATE_OK:Code.SAVE_ERR,flag?"修改成功":"修改失败");
    }

    @ApiOperation(value = "注销账户")
    @DeleteMapping("/4")
    public Result Delete(@RequestBody LoginDto loginDto){
        boolean flag=userService.deleteUser(loginDto);
        return new Result(flag? Code.DELETE_OK:Code.DELETE_ERR,flag?"删除成功":"删除失败");
    }

    @ApiOperation(value = "找回密码")
    @PostMapping("/5")
    public Result SelectPassword(@RequestParam String phone) {
        String password = userService.selectPassword(phone);
        System.out.println(password);
        if (password == null || password.length() == 0) {
            return new Result(Code.GET_ERR, "号码不存在");
        } else {
            return new Result(password, Code.GET_OK, "找回成功");

        }
    }

}