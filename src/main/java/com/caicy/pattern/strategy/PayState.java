package com.caicy.pattern.strategy;

/**
 *
 * 调用支付接口返回实体类
 *
 */
public class PayState {
    private boolean success;
    //支付链接
    private String payUrl;

    public PayState(boolean success, String payUrl) {
        this.success = success;
        this.payUrl = payUrl;
    }

    public String toString(){
        return ("success" + success +"\n 支付链接" + payUrl);
    }
}
