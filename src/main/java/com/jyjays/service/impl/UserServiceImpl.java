package com.jyjays.service.impl;

import com.jyjays.domain.User;
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
    public User selectUser(User user) {
        return userMapper.selectUser(user);
    }

    @Override
    public User selectUserbyName(String username) {
        return userMapper.selectbyName(username);
    }

    @Override
    public User selectUserWithoutId(String username, String password) {
        return userMapper.selectUserWithoutId(username, password);
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
    public boolean deleteUser(String password) {
        return userMapper.deleteUser(password)>0;
    }
}
