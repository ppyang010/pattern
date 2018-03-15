package com.caicy.pattern.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) {
//        hunger();
//        lazyOneThreadUnsafe();
//        createTime();
//        lazyFour();
        enumTest();
    }

    public static void hunger (){
        Hunger hunger1 = Hunger.getInstance();
        Hunger hunger2 = Hunger.getInstance();
        System.out.println(hunger1);
        System.out.println(hunger2);

    }


    /**
     * lazy方式1线程不安全
     */
    public static void lazyOneThreadUnsafe()  {
        final Set<String> instanceSet = Collections.synchronizedSet(new HashSet<String>());

        int times = 10;
        CyclicBarrier cyclicBarrier =new CyclicBarrier(times);

        ExecutorService executorService = Executors.newFixedThreadPool(times);
        for (int i = 0; i< times; i++){
            executorService.execute(()->{
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                LazyOne lazyOne = LazyOne.getInstance();
                instanceSet.add(lazyOne.toString());
            });
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("size is " +instanceSet.size());
        for(String s : instanceSet){
            System.out.println(s);
        }
    }

    /**
     * 获取性能比较
     *
     */
    public static void createTime(){
        int times =1000000;
        long start = System.currentTimeMillis();
        for (int i =0;i<times;i++){
            Hunger.getInstance();
        }
        long end =System.currentTimeMillis();
        System.out.println("hunger 用时" +(end-start));

        start = System.currentTimeMillis();
        for (int i =0;i<times;i++){
            LazyTwo.getInstance();
        }
        end =System.currentTimeMillis();
        System.out.println("lazyTwo 用时" +(end-start));

        start = System.currentTimeMillis();
        for (int i =0;i<times;i++){
            LazyThree.getInstance();
        }
        end =System.currentTimeMillis();
        System.out.println("LazyThree 用时" +(end-start));

    }

    public static void lazyFour(){
        LazyFour.init();
    }

    public static void enumTest(){
//        Enum.valueOf("black");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
        System.out.println("BLACK".equals(Enum.BLACK.toString()));

    }
}
