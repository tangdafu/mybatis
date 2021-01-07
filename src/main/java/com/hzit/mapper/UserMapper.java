package com.hzit.mapper;

import com.hzit.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    void insert(User user);
    void updateById(User user);
}
