package com.caicy.pattern.command.demo;

public class Bug implements Task{
    private String taskName;
    private Programmer programmer;

    public Bug(String taskName, Programmer programmer) {
        this.taskName = taskName;
        this.programmer = programmer;
    }

    @Override
    public void execute() {
        programmer.handleBug(taskName);
    }
}
