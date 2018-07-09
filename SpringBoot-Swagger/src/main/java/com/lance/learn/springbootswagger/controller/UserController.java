package com.lance.learn.springbootswagger.controller;

import com.lance.learn.springbootswagger.bean.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lance(ZYH)
 * @function
 * @date 2018-07-09 21:55
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {


    @ApiOperation(value = "查询用户", notes = "根据UserId对象查询")
    @ApiImplicitParam(name = "userId", value = "id", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public User findById(@PathVariable("id") Long id) {
        return new User();
    }

    @ApiOperation(value = "添加用户", notes = "根据User对象添加")
    @ApiImplicitParam(name = "user", value = "user", required = true, dataType = "User")
    @RequestMapping(method = RequestMethod.GET, value = "add")
    public User insert() {
        User user = new User();
        user.setId(Long.valueOf("123"));
        user.setUsername("张三");
        user.setPassword("1234567");
        return user;
    }
}
