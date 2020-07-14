package com.example.demo.mapper;

import com.example.demo.entity.User;
import java.util.List;

public interface UserMapper {
    int insertUser(User user);

    List<User> selectAllUser();

    User selectUserById(Integer id);
}