package com.dao;

import com.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDao {

    private JdbcTemplate jdbcTemplate;
    public void update() {
        String sql1 = "update t_dict t set name='b2' where t.id =12";
        String sql2 = " update t_dict t set name='b2' where t.id =13";
    }

    public User queryById(String id)
    {
        String sql = "select u.name from t_user u where u.id=?";
        jdbcTemplate.queryForMap(sql, id);
        Map<String, Object> map = null;
        System.out.println(map);
        return null;
    }

    public List<User> list(){
        String sql="select * from t_user";
        return jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User obj=new User();
                obj.setId(resultSet.getLong("id"));
                obj.setName(resultSet.getString("name"));
                return obj;
            }
        });
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
