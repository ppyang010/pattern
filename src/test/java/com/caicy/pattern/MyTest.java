package com.caicy.pattern;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTest {
    public static volatile Integer x = 0;

//    public  static volatile AtomicInteger atomicInteger = new AtomicInteger(0);

    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
//        interrupt();
//        synchronized (MyTest.class){
//
//        }
        add();
        call call = new call();
    }

    private static void number() {
        new BigDecimal("123");
        System.out.println(0.2 + 0.1);
        System.out.println(0.3 - 0.1);
        System.out.println(0.2 * 0.1);
        System.out.println(0.3 / 0.1);
    }


    public static void linkedMap() {
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        map.put("1", 1);
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("testhashset");
    }

    public static void interrupt() throws InterruptedException {
        Thread interrputDemo = new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(i);
        }, "interrputDemo");
        interrputDemo.start();
        TimeUnit.SECONDS.sleep(1);
        interrputDemo.interrupt();
    }


    public static void add() throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(10000);
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
//                        atomicInteger.incrementAndGet();
                atomicInteger.decrementAndGet();
            }).start();
        }
        Thread.sleep(100);
        System.out.println(atomicInteger.get());
//        lock.lock();
//        lock.unlock();

//        CountDownLatch countDownLatch = new CountDownLatch(3);
//        countDownLatch.countDown();
//        countDownLatch.countDown();
//        countDownLatch.countDown();
//        countDownLatch.await();

        new AtomicInteger(3);


    }

    //    private static Unsafe getUnsafeInstance() throws SecurityException,
//            NoSuchFieldException, IllegalArgumentException,
//            IllegalAccessException {
//        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
//        theUnsafeInstance.setAccessible(true);
//        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
//    }
    private static class call implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "hello";
        }
    }
}