package com.caicy.pattern.strategy;

import com.caicy.pattern.strategy.pay.PayType;
import com.caicy.pattern.strategy.pay.Payment;

public class Order {
    private String uid;
    private String orderId;
    private long amount; //支付金额

    public Order(String uid, String orderId, long amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    //调用支付接口并返回支付连接
    public PayState pay(PayType p){
        System.out.println("调用第3方支付接口");
        return p.get().pay();

    }

}
