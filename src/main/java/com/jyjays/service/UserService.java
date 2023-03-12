package com.jyjays.service;

import com.jyjays.domain.User;
import com.jyjays.dto.LoginDto;
import com.jyjays.dto.PhoneDto;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {

    public User selectUser(LoginDto loginDto);

    public User selectUserbyName(String username);

    public String selectPassword(PhoneDto phoneDto);

//    public User selectUserbyMap(Map<String,String> map);
    public boolean insertUser(User user);

    public boolean updateUser(User registerDto);

    public boolean deleteUser(LoginDto loginDto);

}
