package com.caicy.pattern.strategy.pay;

import com.caicy.pattern.strategy.PayState;

public interface Payment {

    PayState pay();
}
