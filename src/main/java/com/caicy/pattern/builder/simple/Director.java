package com.caicy.pattern.builder.simple;

import com.caicy.pattern.builder.simple.product.Hero;

/**
 * 指挥者
 */
public class Director {
    IBuilder builder;
    public Hero construct(){
        System.out.println("build");
        builder = new HeroABuilder();
        return builder.buildA("mock").buildB("mock").buildC("mock").build();
    }
}
