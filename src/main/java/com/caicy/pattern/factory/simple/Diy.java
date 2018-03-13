package com.caicy.pattern.factory.simple;

import com.caicy.pattern.factory.GPU;

public class Diy {
    public static void main(String[] args) {
        GPU gpu = SimpleFactory.build("1060");
        gpu.work();
    }
}
