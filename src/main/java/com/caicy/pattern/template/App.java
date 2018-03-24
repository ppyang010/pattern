package com.caicy.pattern.template;

import com.caicy.pattern.template.entity.User;
import com.caicy.pattern.template.jdbc.DBTool;
import com.caicy.pattern.template.mytemplate.typeA.MyDao;

import java.util.List;

public class App {
    public static void main(String[] args) {
        //使用jdbc
        List<User> list = DBTool.execute("SELECT * FROM sys_users where id = ?", new String[]{"1"});
        show(list);

        System.out.println("my jdbcTemplate");
        MyDao myDao = new MyDao();
        myDao.setMyJdbcTemplate(null);
        list = myDao.listUsers();
        show(list);
    }

    private static void show(List<User> list) {
        list.stream().forEach((u)-> System.out.println(u.getId()));
    }
}
