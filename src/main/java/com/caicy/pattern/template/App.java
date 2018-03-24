package com.caicy.pattern.template;

import com.caicy.pattern.template.entity.User;
import com.caicy.pattern.template.jdbc.DBTool;
import com.caicy.pattern.template.mytemplate.typeA.UserDaoA;
import com.caicy.pattern.template.mytemplate.typeA.UserTemplateA;

import java.util.List;

public class App {
    public static void main(String[] args) {
        //使用jdbc
        List<User> list = DBTool.execute("SELECT * FROM sys_users where id = ?", new String[]{"1"});
        show(list);

        System.out.println("my jdbcTemplate 模板方法模式 使用抽象类的方式");
        UserDaoA userDaoA = new UserDaoA();
        userDaoA.setMyJdbcTemplate(new UserTemplateA());
        list = userDaoA.listUsers();
        show(list);
    }

    private static void show(List<User> list) {
        list.stream().forEach((u)-> System.out.println(u.getId()));
    }
}
