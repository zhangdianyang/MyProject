package com.zdy.dao;

import com.zdy.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zdy
 */
@Repository
public interface UserDao {

    /**
     * chaxun
     * @return
     */
    List<User> findUser();
}
