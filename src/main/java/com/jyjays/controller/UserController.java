package com.jyjays.controller;

import com.jyjays.domain.User;
import com.jyjays.dto.LoginDto;
import com.jyjays.dto.PhoneDto;
import com.jyjays.dto.RegisterDto;

import com.jyjays.service.ResultService;
import com.jyjays.service.UserService;
import com.jyjays.utils.JwtUtils;
import com.jyjays.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import javax.validation.Valid;



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

    @Resource
    private ResultService resultService;

    @ApiOperation(value = "用户登录" )
    @GetMapping("/login")
    public Result selectUser(@RequestBody @Valid LoginDto loginDto, BindingResult bindingResult){
        Result sb = resultService.getResult(bindingResult);
        if (sb != null) return sb;
        User user1=userService.selectUser(loginDto);
        if(user1==null){
            return new Result(Code.GET_ERR,"登陆失败");
        }
        String token= jwtUtils.generateToken(loginDto.getUsername());
        redisUtil.set(loginDto.getUsername(), token);
        return new Result(token,Code.GET_OK,"登陆成功");
    }



    @ApiOperation(value = "用户注册")
    @PostMapping("/2")
    public Result Register(@RequestBody @Valid RegisterDto registerDto, BindingResult bindingResult){

        Result sb = resultService.getResult(bindingResult);
        if (sb != null) return sb;

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
    @PutMapping("/3/{username}")
    public Result Update( @PathVariable("username") String username , @Valid @RequestBody RegisterDto registerDto,BindingResult bindingResult){
        Result sb =resultService.getResult(bindingResult);
        if(sb != null) return sb;
        User user = userService.selectUserbyName(username);
        if(user == null )return new Result(Code.GET_ERR,"用户不存在");
        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());
        user.setPhone(registerDto.getPhone());
        userService.updateUser(user);
        return new Result(user,Code.UPDATE_OK,"修改成功");
    }

    @ApiOperation(value = "注销账户")
    @DeleteMapping("/4")
    public Result Delete(@RequestBody @Valid LoginDto loginDto,BindingResult bindingResult){
        Result sb = resultService.getResult(bindingResult);
        if (sb!=null) return sb;
        User user = userService.selectUser(loginDto);
        if(user==null) return new Result(Code.GET_ERR,"用户名或密码输入错误");
        boolean flag=userService.deleteUser(loginDto);
        return new Result(flag? Code.DELETE_OK:Code.DELETE_ERR,flag?"删除成功":"删除失败");
    }

    @ApiOperation(value = "找回密码")
    @PostMapping("/5")
    public Result SelectPassword(@RequestBody PhoneDto phoneDto,BindingResult bindingResult) {
        Result sb = resultService.getResult(bindingResult);
        if(sb!=null)return sb;
        String password = userService.selectPassword(phoneDto);
        if (password == null || password.length() == 0) {
            return new Result(Code.GET_ERR, "用户名或手机号输入错误");
        } else {
            return new Result(password, Code.GET_OK, "找回成功");
        }
    }
}