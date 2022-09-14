package JUCTest.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TreadPoolDemo1 {
    public static void main(String[] args) {
       ExecutorService threadPool1= Executors.newFixedThreadPool(10);

        try {
            for(int i=0;i<10;i++){
                threadPool1.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"do something");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool1.shutdown();
        }

    }
}
