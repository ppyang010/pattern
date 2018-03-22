package com.caicy.pattern.strategy.pay;

import com.caicy.pattern.strategy.PayState;

public class WeChatPay implements Payment{
    @Override
    public PayState pay() {
        return new PayState(true,"微信支付链接");

    }
}
