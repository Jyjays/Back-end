package com.jyjays.service.impl;

import com.jyjays.domain.User;
import com.jyjays.dto.LoginDto;
import com.jyjays.dto.PhoneDto;
import com.jyjays.mapper.ArticleMapper;
import com.jyjays.mapper.UserMapper;
import com.jyjays.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ArticleMapper articleMapper;


    @Override
    public User selectUser(LoginDto loginDto) {
        return userMapper.selectUser(loginDto);
    }

    @Override
    public User selectUserbyName(String username) {
        return userMapper.selectbyName(username);
    }

    @Override
    public String selectPassword(PhoneDto phoneDto) {
        return userMapper.selectPassword(phoneDto);
    }

    @Override
    public boolean insertUser(User user) {
        return userMapper.insertUser(user)>0;
    }

    @Override
    public boolean updateUser(User registerDto) {
        int flag =  userMapper.updateUser(registerDto);
        int flag2= articleMapper.updateWriter(registerDto.getId(), registerDto.getUsername());
        return flag>0 && flag2>0;
    }

    @Override
    public boolean deleteUser(LoginDto loginDto) {
        return userMapper.deleteUser(loginDto)>0;
    }
}
