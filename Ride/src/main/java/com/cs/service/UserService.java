package com.cs.service;

import com.cs.dao.MybatisUtil;
import com.cs.dao.UserMapper;
import com.cs.entity.User;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author:Yanlong Wang
 * @Date:${date}_${time}
 * @Description:
 */
public class UserService {
    public User addUser(User user){
        SqlSession session = MybatisUtil.getSqlSession();
        session.getMapper(UserMapper.class).addUser(user);
        session.commit();
        MybatisUtil.closeSqlSession();
        return user;

    }
    public User checkLogin(User user){
        SqlSession session = MybatisUtil.getSqlSession();
        User result = session.getMapper(UserMapper.class).checkLogin(user);
        session.commit();
        MybatisUtil.closeSqlSession();
        return result;
    }
    public User getUserById(int id){
        SqlSession session = MybatisUtil.getSqlSession();
        User result = session.getMapper(UserMapper.class).getUserById(id);
        session.commit();
        MybatisUtil.closeSqlSession();
        return result;
    }

}
