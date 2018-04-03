package com.caicy.pattern.builder.effective_java;

import com.caicy.pattern.builder.effective_java.product.EHero;
import com.caicy.pattern.builder.effective_java.product.PartA;

public class APP {
    public static void main(String[] args) {
        EHero hello = new EHero.Builder("ccy").partA(new PartA()).build();
    }
}
