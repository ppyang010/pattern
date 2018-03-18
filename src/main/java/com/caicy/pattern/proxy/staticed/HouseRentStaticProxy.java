package com.caicy.pattern.proxy.staticed;

import com.caicy.pattern.proxy.HouseOwnerA;
import com.caicy.pattern.proxy.HouseRent;

/**
 * 静态代理类
 * 代理类代理了哪些 被代理类的方法是硬编码实现的 发生扩展的时候要重新编写
 * Created by Administrator on 2018/3/18.
 */
public class HouseRentStaticProxy {
    /**
     * 需要持有一个被代理类的引用
     */
    private HouseRent houseRent;

    /**
     * 不够灵活 只能代理一个具体的类
     * @param rent
     */
    public  HouseRentStaticProxy(HouseRent rent){
        this.houseRent=rent;
    }
    public void before(){
        System.out.println("确定租期，房租，押金");
    }

    public void after(){
        System.out.println("拿到钥匙");
    }

    public void doRent(String who){
        this.before();
        this.houseRent.rentOut(who);
        this.after();
    }



}
