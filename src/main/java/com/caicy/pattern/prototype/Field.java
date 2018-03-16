package com.caicy.pattern.prototype;

import java.io.Serializable;

public class Field implements Cloneable,Serializable{

    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    protected Field clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException exception) {
            throw new RuntimeException(exception);
        }
        return (Field) object;
    }

}
