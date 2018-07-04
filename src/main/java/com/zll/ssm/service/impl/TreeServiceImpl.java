package com.zll.ssm.service.impl;

import com.zll.ssm.dao.TreeDAO;
import com.zll.ssm.pojo.Tree;
import com.zll.ssm.service.TreeService;
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
public class TreeServiceImpl implements TreeService {
    @Autowired
    private TreeDAO treeDAO;

    private static final Logger logger = LoggerFactory.getLogger(TreeServiceImpl.class);

    public int insert(Tree record) {
        return this.treeDAO.insert(record);
    }

    public int save(Tree record) {
        return this.treeDAO.save(record);
    }

    public int saveBatch(List<Tree> list) {
        return this.treeDAO.saveBatch(list);
    }

    public Tree selectById(Integer id) {
        return this.treeDAO.selectById(id);
    }

    public Tree get(Tree record) {
        return this.treeDAO.get(record);
    }

    public int update(Tree record) {
        return this.treeDAO.update(record);
    }

    public int delete(Integer id) {
        return this.treeDAO.delete(id);
    }

    public List<Tree> selectList() {
        return this.treeDAO.selectList();
    }

    public int total() {
        return this.treeDAO.total();
    }
}