package com.caicy.pattern.strategy;

import com.caicy.pattern.strategy.pay.AliPay;
import com.caicy.pattern.strategy.pay.PayType;

public class App {

    public static void main(String[] args) {
        //通过模拟不同的支付渠道来演示策略模式


        //省略把商品添加到购物车，再从购物车下单
        //点击 下单 创建订单
        Order order = new Order("1","20180311001000009",324);
        //开始支付，选择微信支付、支付宝、银联卡、京东白条、财付通 用户选择支付方式
        //每个渠道它支付的具体逻辑是不一样的
        //但最终的目的都是一样的
        PayType payType = null;
        if(true){
            System.out.println("根据用户选择判断支付方式");
            payType = PayType.WECHAT_PAY;
        }else {

        }

        //这个值是在支付的时候才决定用哪个值
        System.out.println(order.pay(payType));



    }
}
