package com.zll.ssm.service.impl;

import com.zll.ssm.dao.TestDAO;
import com.zll.ssm.pojo.Test;
import com.zll.ssm.service.TestService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangll
 * @date:  2018-06-29 10:08:22
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDAO testDAO;

    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    public int insert(Test record) {
        return this.testDAO.insert(record);
    }

    public int save(Test record) {
        return this.testDAO.save(record);
    }

    public int saveBatch(List<Test> list) {
        return this.testDAO.saveBatch(list);
    }

    public Test selectById(Integer id, Integer id1) {
        return this.testDAO.selectById(id,id1);
    }

    public Test get(Test record) {
        return this.testDAO.get(record);
    }

    public int update(Test record) {
        return this.testDAO.update(record);
    }

    public int delete(Integer id, Integer id1) {
        return this.testDAO.delete(id,id1);
    }

    public List<Test> selectList() {
        return this.testDAO.selectList();
    }

    public int total() {
        return this.testDAO.total();
    }
}