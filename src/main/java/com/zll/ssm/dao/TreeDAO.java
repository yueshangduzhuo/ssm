package com.zll.ssm.dao;

import com.zll.ssm.pojo.Tree;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author zhangll
 * @date:  2018-06-29 10:08:22
 */
@Repository
public interface TreeDAO {
    /** 
     * 基本的插入
     * @param record 插入字段对象
     */
    int insert(Tree record);

    /** 
     * 判断字段是否为null的插入（不包括主键）
     * @param record 插入字段对象
     */
    int save(Tree record);

    /** 
     * 判断字段是否为null的批量插入（不包括主键）
     * @param list
     */
    int saveBatch(List<Tree> list);

    /** 
     *
     * @param id 主键ID
     */
    Tree selectById(Integer id);

    /** 
     * 根据所有的字段查找单个对象
     * @param record 查询字段对象
     */
    Tree get(Tree record);

    /** 
     * 根据主键修改对象（做了为null判断）
     * @param record 修改字段对象 (必须含ID)
     */
    int update(Tree record);

    /** 
     * 根据主键删除
     * @param id 主键ID
     */
    int delete(Integer id);

    /** 
     * 查询list
     */
    List<Tree> selectList();

    /** 
     * 查询条数
     */
    int total();
}