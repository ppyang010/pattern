package com.caicy.pattern.singleton;

/**
 * 懒汉 方式3
 * 线程安全
 * 双检查方式 性能比2好一点
 */
public class LazyThree {
    //必须要加volatile
    //原因 指令重排序的问题 几率很小
    //
    private static volatile LazyThree instance;

    private LazyThree() {

    }

    public static final LazyThree getInstance() {
        if (null == instance) {
            synchronized (LazyThree.class) {
                //这里的检查不能少
                if (null == instance) {
                    instance = new LazyThree();
                }
            }
        }

        return instance;
    }
}
