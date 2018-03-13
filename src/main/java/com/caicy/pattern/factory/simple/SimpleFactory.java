package com.caicy.pattern.factory.simple;

import com.caicy.pattern.factory.GPU;
import com.caicy.pattern.factory.GPU1060;
import com.caicy.pattern.factory.GPU1070;

public class SimpleFactory {


    /**
     * 生产gpu
     *
     * @param number  型号
     * @return
     */
    public static GPU build(String number){
        switch (number){
            case "1060":
                return new GPU1060();
            case "1070":
                return new GPU1070();
            default:
                return null;
        }
    }






//    /**
//     *
//     * @param brand 品牌 七彩虹 微星 华硕  技嘉 等等十几家
//     * @param number 型号 从660 760 860 960 970 980 1050 等等上百种型号
//     * 。。。在此之外还有如内存大小之类等其他型号
//     * 简单工厂模式 创建 或扩展方法变得越来越复杂 就需要进一步等封装 工厂方法模式
//     * @return
//     */
//    public static GPU build(String brand,String number){
//        return null;
//    }

}
