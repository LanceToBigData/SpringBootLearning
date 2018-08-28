package com.lance.learn.springbootmybatis.controller;

import com.lance.learn.springbootmybatis.bean.User;
import com.lance.learn.springbootmybatis.commons.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Lance(ZYH)
 * @Date: 2018/8/28 10:31
 * @Description:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    /**
     * 查找所有的用户
     * @return
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public Response findAllUsers(){
        List<User> userList = new ArrayList<>();
        for (int i =1 ; i<=10;i++){
            User user = new User();
            user.setName("lance"+String.valueOf(i));
            user.setAge(12+i);
            user.setAdress("江西"+String.valueOf(i));
            user.setPhone("110"+String.valueOf(i));
            user.setRegisterDate(new Date());
            userList.add(user);
        }

        if (userList.size() != 0){
            return new Response().packageData("list",userList);
        }
        return new Response().failure("无用户信息");

    }
}
