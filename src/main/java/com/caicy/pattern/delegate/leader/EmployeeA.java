package com.caicy.pattern.delegate.leader;

public class EmployeeA implements Worker{


    @Override
    public void doWorker(String cmd) {
        System.out.println("我是员工A，我现在开始干" + cmd + "工作");
    }
}
