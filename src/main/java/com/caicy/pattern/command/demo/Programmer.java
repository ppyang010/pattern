package com.caicy.pattern.command.demo;

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
