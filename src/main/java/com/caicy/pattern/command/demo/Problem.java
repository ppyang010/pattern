package com.caicy.pattern.command.demo;

public class Problem implements Task{

    private String taskName;
    private Programmer programmer;


    public Problem(String taskName, Programmer programmer) {
        this.taskName = taskName;
        this.programmer = programmer;
    }

    @Override
    public void execute() {
        programmer.handleProblem(taskName);
    }
}
