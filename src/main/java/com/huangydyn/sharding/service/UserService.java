package com.huangydyn.sharding.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huangydyn.sharding.mapper.UserMapper;
import com.huangydyn.sharding.pojo.UserModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public Integer addUser(UserModel user) {
        return userMapper.insert(user);
    }

    public List<UserModel> getUsers() {
        return userMapper.selectList(new QueryWrapper<>());
    }

    public UserModel getUser(Integer id) {
        return null;
    }

    public boolean deleteOne(Integer id) {
        int i = userMapper.deleteById(id);
        return i > 0;
    }

    public boolean update(UserModel user) {
        int i = userMapper.updateById(user);
        return i > 0;
    }

    public List<UserModel> selectByJoinStatus() {
        return userMapper.selectByJoinStatus();
    }
}