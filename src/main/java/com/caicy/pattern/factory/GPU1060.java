package com.caicy.pattern.factory;

public class GPU1060 implements GPU,Cloneable{
    @Override
    public void work() {
        System.out.println("公版1060");
    }


    @Override
    protected GPU1060 clone()  {
        try {
            return (GPU1060) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
