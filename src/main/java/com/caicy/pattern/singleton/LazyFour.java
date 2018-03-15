package com.caicy.pattern.singleton;

/**
 * 懒汉 方式4 最好的方式
 * 线程安全
 * 性能好
 * 没有资源浪费
 *
 * 使用内部静态类饿汉
 */
public class LazyFour {

    private static boolean initialized = false;
    static {
        System.out.println("加载外部");
    }

    public static void init(){

    }

    private LazyFour(){
        //防止反射入侵
        synchronized (LazyFour.class){
            if(initialized == false){
                initialized = !initialized;
            }else{
                throw new RuntimeException("单例已被侵犯");
            }
        }

    }

    //每一个关键字都不是多余的
    //static 是为了使单例的空间共享
    //final 保证这个方法不会被重写，重载
    public static final  LazyFour getInstance(){
        //在返回结果以前，一定会先加载内部类
        return Lazy.instance;
    }

    //没有涉及到内部静态类元素时 默认不加载内部静态类
    private static class Lazy{
        static{
            System.out.println("初始化内部");
        }
        private static LazyFour instance = new LazyFour();
    }
}
