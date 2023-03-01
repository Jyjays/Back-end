package com.jyjays.service.impl;

import com.jyjays.domain.User;
import com.jyjays.dto.LoginDto;
import com.jyjays.mapper.UserMapper;
import com.jyjays.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User selectUser(LoginDto loginDto) {
        return userMapper.selectUser(loginDto);
    }

    @Override
    public User selectUserbyName(String username) {
        return userMapper.selectbyName(username);
    }

    @Override
    public boolean insertUser(User user) {
        return userMapper.insertUser(user)>0;
    }

    @Override
    public boolean updateUserPassword(Map<String, Object> map) {
        return userMapper.updateUserPassword(map)>0;
    }

    @Override
    public boolean deleteUser(LoginDto loginDto) {
        return userMapper.deleteUser(loginDto)>0;
    }
}
