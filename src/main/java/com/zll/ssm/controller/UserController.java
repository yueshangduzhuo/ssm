package com.zll.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zll.ssm.annotation.LogAnnotation;
import com.zll.ssm.pojo.User;
import com.zll.ssm.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 用户
 * @author: zhangll
 * @date: 2018-06-28 15:38
 **/
@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {""})
    public String view() {
        return "user";
    }

    @LogAnnotation(operateModelNm = "测试方法", operateFuncNm = "保存方法")
    @RequestMapping(value = {"/add"})
    @ResponseBody
    public User add() {
        User user = new User();
        user.setPwd("12334");
        user.setAge(28);
        userService.insert(user);
        userService.save(user);
        List<User> list = new ArrayList();
        list.add(user);
        userService.saveBatch(list);
        System.out.println(userService.get(user));
        List<User> list1 = userService.selectList();
        System.out.println(list1);
        System.out.println(userService.total());
        System.out.println(userService.selectById(user.getId()));
        return user;
    }

    @RequestMapping(value = {"/del"})
    @ResponseBody
    public List<User>  del() {
        userService.delete(2);
        List<User> list = userService.selectList();
        return list;
    }

    @RequestMapping(value = {"/update"})
    @ResponseBody
    public User update() {
        User user = new User();
        user.setPwd("12334");
        user.setAge(1);
        user.setUserName("zll");
        user.setId(3);
        userService.update(user);
        return user;
    }

    @RequestMapping(value = {"/page"})
    @ResponseBody
    public PageInfo<User> page() {
        PageHelper.startPage(1, 3);
        List<User> userList = userService.selectList();
        PageInfo<User> p=new PageInfo<>(userList);
        return p;
    }

    @RequestMapping(value = {"/page1"})
    @ResponseBody
    public PageInfo<User> page1() {
        PageHelper.startPage(1, 3,"id DESC");
        List<User> userList = userService.selectList();
        PageInfo<User> p=new PageInfo<>(userList);
        return p;
    }

    @RequestMapping(value = {"/page2"})
    @ResponseBody
    public PageInfo<User> page2() {
        Map<String ,Object> map = new HashMap<>();
        map.put("start",2);
        map.put("limit","10");
        map.put("count",false);
        PageHelper.startPage(map);
        List<User> userList = userService.selectList();
        PageInfo<User> p=new PageInfo<>(userList);
        return p;
    }

    @RequestMapping(value = {"/page3"})
    @ResponseBody
    public PageInfo<User> page3() {
        Map<String ,Object> map = new HashMap<>();
        map.put("userName","张三");
        PageHelper.startPage(1,10);
        List<User> userList = userService.list(map);
        PageInfo<User> p=new PageInfo<>(userList);
        return p;
    }




}
