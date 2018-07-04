package com.zll.ssm.service;

import com.zll.ssm.pojo.Test;
import java.util.List;

/**
 * @author zhangll
 * @date:  2018-06-29 10:08:22
 */
public interface TestService {
    int insert(Test record);

    int save(Test record);

    int saveBatch(List<Test> list);

    Test selectById(Integer id, Integer id1);

    Test get(Test record);

    int update(Test record);

    int delete(Integer id, Integer id1);

    List<Test> selectList();

    int total();
}