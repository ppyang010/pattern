package com.caicy.pattern.builder.simple;

import com.caicy.pattern.builder.simple.product.Hero;

public interface IBuilder {
    IBuilder buildA(String mockStr);

    IBuilder buildB(String mockStr);

    IBuilder buildC(String mockStr);

    /**
     * 返回产品
     * @return
     */
    Hero build();


}
