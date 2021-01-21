package com.bee.mall.demo.controller;

import com.bee.mall.demo.entity.User;
import com.bee.mall.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * description: 数据库测试类 <br>
 * date: 2021/1/21 22:46 <br>
 * author: Administrator
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getList")
    public List<User> getList() {
        return userService.selectAll();
    }
}
