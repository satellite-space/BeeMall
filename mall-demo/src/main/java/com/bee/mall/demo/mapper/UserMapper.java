package com.bee.mall.demo.mapper;

import com.bee.mall.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description: xxxx <br>
 * date: 2021/1/21 22:50 <br>
 * author: Administrator
 * version: 1.0 <br>
 */
@Mapper
public interface UserMapper {

    List<User> selectAll();
}
