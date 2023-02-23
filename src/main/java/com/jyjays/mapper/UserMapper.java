package com.jyjays.mapper;

import com.jyjays.domain.User;
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

    User selectUserbyMap(Map<String,String> map);

    User selectUser(User user);

    int insertUser(User user);

    //public int insertUser(Map<String,Object> map);
    int updateUserPassword(Map<String,String> map);

    int deleteUser(User user);
}
