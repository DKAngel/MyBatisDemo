package com.example.demo.mapper;

import com.example.demo.common.SexEnum;
import com.example.demo.entity.User;
import com.example.demo.tool.MyBatisTool;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class UserMapperTest {

    @Test
    void insertUser() {
        User user = new User();
        user.setName("dkangel");
        user.setSex(SexEnum.MALE);
        user.setAge(24);

        SqlSession sqlSession = MyBatisTool.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int len;
        try {
            len = userMapper.insertUser(user);
            sqlSession.commit(true);
        } finally {
            sqlSession.close();
        }
        Assert.assertEquals(1, len);
    }

    @Test
    void selectAllUser() {
        SqlSession sqlSession = MyBatisTool.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users;
        try {
            users = userMapper.selectAllUser();
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        Assert.assertEquals(1, users.size());
    }

    @Test
    void selectUserById() {
        SqlSession sqlSession = MyBatisTool.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user;
        try {
            user = userMapper.selectUserById(100);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        Assert.assertEquals("dkangel", user.getName());
    }
}