package com.caicy.pattern.template.mytemplate.typeA;

import com.caicy.pattern.template.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTemplateA extends AbstractJdbcTemplateA {

    @Override
    public User rowMap(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        return user;
    }
}
