package com.zdy.dao;

import com.zdy.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zdy
 */
@Repository
public interface UserDao {

    List<User> findUser();
    User findUserById(                                    );
}
