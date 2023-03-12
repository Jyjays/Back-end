package com.jyjays.mapper;

import com.jyjays.domain.User;
import com.jyjays.dto.LoginDto;
import com.jyjays.dto.PhoneDto;
import com.jyjays.dto.RegisterDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper

{
    @Select("select * from loguesr where username=#{username}")
    User selectbyName(String username);

    @Select("select *from loguesr where username=#{username} and password=#{password}")
    User selectUserWithoutId(String username,String password);

//    User selectUserbyMap(Map<String,String> map);

    User selectUser(LoginDto loginDto);

    String selectPassword(PhoneDto phoneDto);

    int insertUser(User user);

    //public int insertUser(Map<String,Object> map);
    int updateUser(User user);

    int deleteUser(LoginDto loginDto);
}
