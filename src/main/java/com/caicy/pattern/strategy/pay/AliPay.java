package com.caicy.pattern.strategy.pay;

import com.caicy.pattern.strategy.PayState;

public class AliPay implements Payment {
    @Override
    public PayState pay() {
        return new PayState(true,"支付宝支付链接");
    }
}
