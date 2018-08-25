package com.caicy.pattern.command.demo;

/**
 * 程序员
 * 对应接受者角色
 *
 * 这里可以改进 比如假设这里是一个程序员小组 在接受到任务后可以进行再分配
 * @author ccy
 */
public class Programmer {

    private String name;

    public Programmer(String name) {
        this.name = name;
    }

    public void handleBug(String taskName) {
        System.out.println(this.name + " resolve Bug" + taskName);
    }

    public void handleProblem(String taskName) {
        System.out.println(name + " resolve Problem" + taskName);
    }


}
