package com.caicy.pattern.template;

import com.caicy.pattern.template.jdbc.DBTool;

public class App {
    public static void main(String[] args) {
        DBTool.execute("SELECT * FROM sys_users where id = ?",new String [] {"1"});

    }
}
