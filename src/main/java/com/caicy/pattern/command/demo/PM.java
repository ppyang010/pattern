package com.caicy.pattern.command.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品经理
 * 对应请求者角色
 * @author ccy
 */
public class PM {

    private List<Task> tasks = new ArrayList<>();


    public void receive(Task task){
        tasks.add(task);
    }


    public void assign(){
        tasks.forEach(Task::execute);
    }




}
