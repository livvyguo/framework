package com.lvy.framework.gardener.mapper;


import com.lvy.framework.gardener.model.User;

/**
 * Created by Administrator on 2014/12/2.
 */
public interface UserMapper {

    public User selectUser(int id);

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUser(int id);
}
