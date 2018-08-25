package com.caicy.pattern.command.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品经理
 * 对应请求者角色
 *  接受命令
 *  分配和控制命令的执行
 * @author ccy
 */
public class PM {

    private List<Task> tasks = new ArrayList<>();


    public void receive(Task task){
        tasks.add(task);
    }


    public void assign(){
        //可以控制执行的命令列表，方便记录，撤销/重做以及事务等功能。
        //可以将命令排队，有序执行
        tasks.forEach(Task::execute);
    }




}
