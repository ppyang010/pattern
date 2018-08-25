package com.caicy.pattern.command.demo;

/**
 * 运营人员
 * client 角色
 *
 * @author ccy
 */
public class Operation {

    public static void main(String[] args) {
        Programmer programmer = new Programmer("ccy");
        Bug bugA = new Bug("bugA", programmer);
        Bug bugB = new Bug("bugB", programmer);
        Problem problemA = new Problem("problemA", programmer);

        PM pm = new PM();
        pm.receive(bugA);
        pm.receive(bugB);
        pm.receive(problemA);
        pm.assign();

    }
}
