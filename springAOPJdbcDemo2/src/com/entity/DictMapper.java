package com.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
 *用户：sky-吴
 *日期：2019/7/8
 */

/**
 * 从数据库中获取一行数据构成一个对象的接口
 */
public class DictMapper implements RowMapper<Dict> {
    @Override
    public Dict mapRow(ResultSet rs, int i) throws SQLException {
        Dict obj = new Dict();
        obj.setId(rs.getLong("id"));
        obj.setName(rs.getString("name"));
        obj.setDkey(rs.getString("dkey"));
        obj.setDval(rs.getString("dval"));
        obj.setUseFlag(rs.getInt("use_flag"));
        obj.setOrderNo(rs.getInt("order_no"));
        obj.setCreateDate(rs.getDate("create_Date"));
        return obj;
    }
}
