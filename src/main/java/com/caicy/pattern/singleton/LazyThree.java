package com.caicy.pattern.singleton;

/**
 * 懒汉 方式3
 * 线程安全
 * 双检查方式 性能比2好一点
 */
public class LazyThree {
    private static LazyThree instance ;

    private LazyThree(){

    }

    public static final  LazyThree getInstance(){
        if(null == instance){
            synchronized (LazyThree.class){
                //这里的检查不能少
                if(null== instance){
                    return new LazyThree();
                }
            }
        }

        return instance;
    }
}
