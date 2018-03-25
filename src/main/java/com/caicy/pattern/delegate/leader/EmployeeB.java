package com.caicy.pattern.delegate.leader;

public class EmployeeB implements Worker{
    @Override
    public void doWorker(String cmd) {
        System.out.println("我是员工B，我现在开始干" + cmd + "工作");
    }
}
