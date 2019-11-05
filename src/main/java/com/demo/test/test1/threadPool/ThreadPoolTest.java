package com.demo.test.test1.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    //可缓存的线程池
    private static ExecutorService cachedExecutor = Executors.newCachedThreadPool();
    //定长线程池，每当提交一个任务就创建一个线程，直到达到线程池的最大数量，这时线程数量不在变化，当线程发生错误结束时，线程池就会补充一个新的线程。
    static ExecutorService fixedExecutor = Executors.newFixedThreadPool(3);
    //单线程的线程池，线程一场结束，会创建一个新的线程，能确保任务按提交顺序执行。
    static ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
    //单线程可执行周期性任务的线程池
    static ScheduledExecutorService singleScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    //定长线程池，可执行周期性任务
    static ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(3);
    //任务窃取线程池，不保证执行顺序，适合任务耗时差异较大的模式
    static ExecutorService workStealingExecutor = Executors.newWorkStealingPool();

    public static void main(String[] args){
        testCachedExecutor();
        testFixedExecutor();
        testSingleExecutor();
        testSingleScheduledExecutor();
        testScheduledExecutor();
        testWorkStealingExecutor();
    }

    private static void testCachedExecutor(){
        for(int i =0;i<6;i++){
            final int index = i;
            cachedExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"===index==="+index);
                }
            });
        }
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("5 seconds later ...");
        cachedExecutor.shutdown();
    }

    private static void testFixedExecutor(){
        for(int i=0;i<6;i++){
            final int index = i;
            fixedExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(3000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"==========="+index);
                }
            });
        }
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("4 seconds later ...");
        fixedExecutor.shutdown();
    }

    private static void testSingleExecutor(){
        for(int i=0;i<6;i++){
            final int index = i;
            singleExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(3000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"==========="+index);
                }
            });
        }
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("4 seconds later ...");
        singleExecutor.shutdown();
    }

    private static void testSingleScheduledExecutor(){
        for(int i=0;i<6;i++){
            final int index = i;
            singleScheduledExecutor.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"==========="+index);
                }
            },0,3, TimeUnit.SECONDS);
        }
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("4 seconds later ...");
        singleScheduledExecutor.shutdown();
    }

    private static void testScheduledExecutor(){
        for(int i=0;i<6;i++){
            final int index = i;
            scheduledExecutor.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"==========="+index);
                }
            },0,3, TimeUnit.SECONDS);
        }
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("4 seconds later ...");
        scheduledExecutor.shutdown();
    }

    private static void testWorkStealingExecutor(){
        for(int i =0;i<6;i++){
            final int index = i;
            workStealingExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"==========="+index);
                }
            });
        }
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("4 seconds later ...");
    }
}
