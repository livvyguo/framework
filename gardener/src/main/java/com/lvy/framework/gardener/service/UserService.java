package com.lvy.framework.gardener.service;


import com.lvy.framework.gardener.dao.UserDao;
import com.lvy.framework.gardener.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2014/12/2.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(Integer id) {
        return this.userDao.getUserById(id);
    }
}
