package JUCTest.keyword;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycliBarrierDemo {
    private static final int NUMBER=7;
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier=new CyclicBarrier(NUMBER, ()->{
            System.out.println("完成");
        });
        for(int i=0;i<7;i++){
            new Thread(()->{
                System.out.println("做了点事情");
                try {
                    cyclicBarrier.await();
                    System.out.println("再做些事情");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
