package com.jyjays.service;

import com.jyjays.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
public interface UserService {
    /**
     *
     * @param user
     * @return
     */
    public User selectUser(User user);

    public User selectUserbyName(String username);

    public User selectUserWithoutId(String username,String password);

    public User selectUserbyMap(Map<String,String> map);
    /**
     *
     * @param user
     * @return
     */
    public boolean insertUser(User user);

    public boolean updateUserPassword(Map<String, String> map);

    public boolean deleteUser(User user);

}
