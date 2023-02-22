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
    /**
     *
     * @param user
     * @return
     */
    public boolean insertUser(User user);

    public boolean updateUserPassword(Map<String,Object> map);

    public boolean deleteUser(String password);

}
