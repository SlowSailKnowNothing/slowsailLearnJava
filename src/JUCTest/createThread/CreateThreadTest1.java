package JUCTest.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThreadTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread1 thread1 = new Thread1();
        new Thread(thread1).start();
        new Thread2().start();
        FutureTask<String> task=new FutureTask<String>(new Thread3());
        new Thread(task).start();
        System.out.println(task.get());

    }

    public static class Thread1 implements Runnable {

        @Override
        public void run() {
            System.out.println("this is a way to create a thread");
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            System.out.println("this is another way to create a thread");
        }
    }

    public static class Thread3 implements Callable<String>{
        @Override
        public String call() {
            return "this is a callable test";
        }
    }
}
