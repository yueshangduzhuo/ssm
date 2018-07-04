package com.zll.ssm.service.impl;

import com.zll.ssm.dao.UserDAO;
import com.zll.ssm.pojo.User;
import com.zll.ssm.service.UserService;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangll
 * @date:  2018-06-29 10:08:22
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public int insert(User record) {
        return this.userDAO.insert(record);
    }

    public int save(User record) {
        return this.userDAO.save(record);
    }

    public int saveBatch(List<User> list) {
        return this.userDAO.saveBatch(list);
    }

    public User selectById(Integer id) {
        return this.userDAO.selectById(id);
    }

    public User get(User record) {
        return this.userDAO.get(record);
    }

    public int update(User record) {
        return this.userDAO.update(record);
    }

    public int delete(Integer id) {
        return this.userDAO.delete(id);
    }

    public List<User> selectList() {
        return this.userDAO.selectList();
    }

    @Override
    public List<User> list(Map<String, Object> map) {
        return this.userDAO.list(map);
    }

    public int total() {
        return this.userDAO.total();
    }


}