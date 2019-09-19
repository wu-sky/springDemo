package com.dao;

import com.entity.Dict;
import com.entity.DictMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/*
 *用户：sky-吴
 *日期：2019/7/8
 */


/**
 * PROPAGATION_REQUIRED -- 支持当前事务，如果当前没有事务，就新建一个事务。这是最常见的选择。
 * PROPAGATION_SUPPORTS -- 支持当前事务，如果当前没有事务，就以非事务方式执行。
 * PROPAGATION_MANDATORY -- 支持当前事务，如果当前没有事务，就抛出异常。
 * PROPAGATION_REQUIRES_NEW -- 新建事务，如果当前存在事务，把当前事务挂起。
 * PROPAGATION_NOT_SUPPORTED -- 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
 * PROPAGATION_NEVER -- 以非事务方式执行，如果当前存在事务，则抛出异常。
 * PROPAGATION_NESTED -- 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则进行与PROPAGATION_REQUIRED类似的操作
 */
//@Transactional//挂一个事务管理注解, 可以配置这个类中的方法所有方法都需要事务处理, 除了头上标明我不用
@Repository
public class DictDao {
    private JdbcTemplate jtp;

    @Autowired//在setter方法里面写都不用创建属性, 照样能注入
    public void setDataSource(DataSource dataSource) {
        //dataSource就被spring注入了
        jtp = new JdbcTemplate(dataSource);
    }
    //头上什么都没标, 我需要事务

    public void updateE(){
        String sql = "update t_dict t  set t.name= 'b1' where t.id = 12";
        int i = jtp.update(sql);
        String sql2 = "update t_dict t  set t.name= 'b1' wher t.id = 13";
        int j = jtp.update(sql2);
        System.out.println("==" + i);
    }
    public void updateR(){
        String sql = "update t_dict t  set t.name= 'b11' where t.id = 12";
        int i = jtp.update(sql);
        String sql2 = "update t_dict t  set t.name= 'b11' where t.id = 13";
        int j = jtp.update(sql2);
        System.out.println("==" + i);
    }

    //以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。告诉spring我不需要事务
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Dict> list(){
        List<Dict> list = new ArrayList<Dict>();
        String sql = "select * from t_dict t";
        //返回一个list
        list = jtp.query(sql, new DictMapper());

        return list;
    }
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public Dict getObjById(){
        String sql = "select * from t_dict t where id = 5";
        //从数据库中读取一行构成一个对象, 需要映射
        Dict d = jtp.queryForObject(sql, new DictMapper());
        return d;
    }

}
