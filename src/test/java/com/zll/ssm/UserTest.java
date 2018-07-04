package com.zll.ssm;

import com.zll.ssm.pojo.User;
import com.zll.ssm.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: user测试
 * @author: zhangll
 * @date: 2018-06-28 09:42
 **/
public class UserTest extends BaseJunit4Test {

    @Autowired
    private UserService userService;

    @Test
    @Transactional   //标明此方法需使用事务
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
    public void test() {
        System.out.println("测试Spring整合Junit4进行单元测试");
        User user = new User();
        user.setAge(123);
        user.setPwd("123123");
        userService.save(user);
    }
}

