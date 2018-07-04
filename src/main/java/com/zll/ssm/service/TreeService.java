package com.zll.ssm.service;

import com.zll.ssm.pojo.Tree;
import java.util.List;

/**
 * @author zhangll
 * @date:  2018-06-29 10:08:22
 */
public interface TreeService {
    int insert(Tree record);

    int save(Tree record);

    int saveBatch(List<Tree> list);

    Tree selectById(Integer id);

    Tree get(Tree record);

    int update(Tree record);

    int delete(Integer id);

    List<Tree> selectList();

    int total();
}