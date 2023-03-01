package com.jyjays.service;

import com.jyjays.domain.User;
import com.jyjays.dto.LoginDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
public interface UserService {

    public User selectUser(LoginDto loginDto);

    public User selectUserbyName(String username);


//    public User selectUserbyMap(Map<String,String> map);
    public boolean insertUser(User user);

    public boolean updateUserPassword(Map<String,Object> map);

    public boolean deleteUser(LoginDto loginDto);

}
