package com.caicy.pattern.builder.simple.product;

public class Hero {

    private String name;

    private PartA partA;
    //模拟B依赖A
    private PartB partB;

    private PartC partC;

    public Hero(String name, PartA partA, PartB partB, PartC partC) {
        this.name = name;
        this.partA = partA;
        this.partB = partB;
        this.partC = partC;
    }

    public Hero() {
    }

    public String getName() {
        return name;
    }

    public Hero setName(String name) {
        this.name = name;
        return this;
    }

    public PartA getPartA() {
        return partA;
    }

    public Hero setPartA(PartA partA) {
        this.partA = partA;
        return this;
    }

    public PartB getPartB() {
        return partB;
    }

    public Hero setPartB(PartB partB) {

        if(this.partA == null){
            System.out.println("模拟B依赖A");
            throw new RuntimeException();
        }
        this.partB = partB;
        return this;
    }

    public PartC getPartC() {
        return partC;
    }

    public Hero setPartC(PartC partC) {
        this.partC = partC;
        return this;
    }
}