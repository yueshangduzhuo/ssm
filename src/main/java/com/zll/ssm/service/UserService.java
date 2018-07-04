package com.zll.ssm.service;

import com.zll.ssm.pojo.User;
import java.util.List;
import java.util.Map;

/**
 * @author zhangll
 * @date:  2018-06-29 10:08:22
 */
public interface UserService {
    int insert(User record);

    int save(User record);

    int saveBatch(List<User> list);

    User selectById(Integer id);

    User get(User record);

    int update(User record);

    int delete(Integer id);

    List<User> selectList();

    List<User> list(Map<String, Object> map);

    int total();
}