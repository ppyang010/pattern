package com.caicy.pattern.template.mytemplate.typeA;

import com.caicy.pattern.template.entity.User;

import java.util.List;

public class UserDaoA {
    AbstractJdbcTemplateA myJdbcTemplate;

    public AbstractJdbcTemplateA getMyJdbcTemplate() {
        return myJdbcTemplate;
    }

    public void setMyJdbcTemplate(AbstractJdbcTemplateA myJdbcTemplate) {
        this.myJdbcTemplate = myJdbcTemplate;
    }

    public List<User> listUsers(){
        List list = myJdbcTemplate.execute("SELECT * FROM sys_users where id = ?", new String[]{"1"});
        return  list;
    }

}
