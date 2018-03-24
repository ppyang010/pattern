package com.caicy.pattern.template.mytemplate.typeB;

import com.caicy.pattern.template.entity.User;

import java.sql.ResultSet;
import java.util.List;

public class UserDaoB {
    private MyJdbcTemplate myJdbcTemplate;

    public MyJdbcTemplate getJdbcTemplate() {
        return myJdbcTemplate;
    }

    public void setJdbcTemplate(MyJdbcTemplate jdbcTemplate) {
        this.myJdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll(){
        String sql = "SELECT * FROM sys_users where id = ?";
        List list = myJdbcTemplate.execute(sql, new String[]{"1"}, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws Exception {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                return user;
            }
        });
        return  list;
    }

    public void setMyJdbcTemplate(MyJdbcTemplate myJdbcTemplate) {
        this.myJdbcTemplate = myJdbcTemplate;
    }
}
