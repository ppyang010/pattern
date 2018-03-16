package com.caicy.pattern.prototype;

import com.caicy.pattern.factory.GPU1060;
import sun.dc.pr.PRError;

import javax.sound.midi.Soundbank;

public class App {
    public static void main(String[] args) {
        Prototype prototype =new Prototype();
        prototype.setA(10);
        prototype.setB("bb");
        prototype.setField(new Field());
        System.out.println(prototype);
        System.out.println(prototype.getA());
        System.out.println(prototype.getB());
        System.out.println(prototype.getField());

        System.out.println("---------java clone 浅copy---------");
        Prototype clone = prototype.simpleCopy();
        System.out.println(clone);
        System.out.println(clone.getA());
        System.out.println(clone.getB());
        System.out.println(clone.getField());
        show(prototype, clone);


        System.out.println("---------java clone 深copy---------");
        clone = prototype.deepClone();
        System.out.println(clone);
        System.out.println(clone.getA());
        System.out.println(clone.getB());
        System.out.println(clone.getField());
        show(prototype, clone);


        System.out.println("---------java clone 深copy 序列化方式---------");
        clone = prototype.serializeClone();
        System.out.println(clone);
        System.out.println(clone.getA());
        System.out.println(clone.getB());
        System.out.println(clone.getField());
        show(prototype, clone);

        System.out.println("---------java clone 浅copy spring反射---------");
        clone = prototype.springRefClone();
        show(prototype, clone);
    }

    private static void show(Prototype prototype, Prototype clone) {
        System.out.println(clone);
        System.out.println(clone.getA());
        System.out.println(clone.getB());
        System.out.println(clone.getField());
        if (prototype.getField() == clone.getField()){
            System.out.println("-------------该方式为浅拷贝---------------");
        }else{
            System.out.println("-------------该方式为深拷贝---------------");
        }
        System.out.println("");
    }
}
