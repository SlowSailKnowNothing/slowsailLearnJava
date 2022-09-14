package JUCTest.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":   "+"run");
    }
}

class MyThread2 implements Callable {
    @Override
    public Object call() throws Exception {
        return 2;
    }
}
public class Thread1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new MyThread(),"aa").start();
        //new Thread(new MyThread2(),"aa").start(); Thread无法直接用callbale来初始化

        FutureTask<Integer> futureTask=new  FutureTask<Integer>(()->{
            int i=0;
            for(i=0;i<1024;i++){
            }
            return i;
        });

        new Thread(futureTask,"futureTest").start();
        while(!futureTask.isDone()){
            System.out.println("wait");
        }

        System.out.println(futureTask.get());
    }


}
