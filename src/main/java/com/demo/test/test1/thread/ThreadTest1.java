package com.demo.test.test1.thread;

/**
 * start方法会启动多线程；而run方法会顺序执行，只能执行完一个run后才会继续执行下一个run
 */
public class ThreadTest1 {
    public static void main(String[] args){
        Runner1 runnable1 = new Runner1();
        Runner2 runnable2 = new Runner2();
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

//        thread1.start();
//        thread2.start();

        thread1.run();
        thread2.run();
    }

}
class Runner1 implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            System.out.println("Runner1============="+i);
        }
    }
}
class Runner2 implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            System.out.println("Runner2============="+i);
        }
    }
}