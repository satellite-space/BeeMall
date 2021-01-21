package com.bee.mall.demo.service.impl;

import com.bee.mall.demo.entity.User;
import com.bee.mall.demo.mapper.UserMapper;
import com.bee.mall.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description: xxxx <br>
 * date: 2021/1/21 22:49 <br>
 * author: Administrator
 * version: 1.0 <br>
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
