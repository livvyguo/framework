package com.lvy.framework.gardener.dao;

import com.lvy.framework.gardener.mapper.UserMapper;
import com.lvy.framework.gardener.model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2014/12/2.
 */
@Repository
public class UserDao extends SqlSessionDaoSupport{

    @Autowired
    public UserDao(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public User getUserById(int id) {
        return getSqlSession().getMapper(UserMapper.class).selectUser(id);
    }
}
