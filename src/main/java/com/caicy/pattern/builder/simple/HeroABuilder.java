package com.caicy.pattern.builder.simple;

import com.caicy.pattern.builder.simple.product.Hero;
import com.caicy.pattern.builder.simple.product.PartA;
import com.caicy.pattern.builder.simple.product.PartB;
import com.caicy.pattern.builder.simple.product.PartC;

public class HeroABuilder implements IBuilder{

    private Hero hero=new Hero();


    @Override
    public HeroABuilder buildA(String mockStr) {
        // 此处根据实际业务写相关逻辑
        hero.setPartA(new PartA());
        return this;
    }

    @Override
    public HeroABuilder buildB(String mockStr) {
        // 此处根据实际业务写相关逻辑
        hero.setPartB(new PartB());
        return this;
    }

    @Override
    public HeroABuilder buildC(String mockStr) {
        // 此处根据实际业务写相关逻辑
        hero.setPartC(new PartC());
        return this;
    }

    /**
     * 返回产品
     * @return
     */
    @Override
    public Hero build() {
        // 此处根据实际业务写相关逻辑
        return this.hero;
    }
}
