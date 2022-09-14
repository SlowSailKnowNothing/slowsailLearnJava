package JUCTest.Sync;

import org.omg.CORBA.UShortSeqHelper;

public class ThreadDemo1 {


    public static class Share{
        int share=0;
        public synchronized void increment() throws InterruptedException {
            if (share == 1) {
                this.wait();
            }
            share++;
            System.out.println(Thread.currentThread().getName() + ":" + share);
            this.notifyAll();
        }

        public synchronized void decrement() throws InterruptedException {
            if(share==0){
                this.wait();
            }
            share--;
            System.out.println(Thread.currentThread().getName()+":"+share);
            this.notifyAll();
        }

        public static void main(String[] args) {
            Share share=new Share();
            new Thread(()->{
                for(int i=0;i<10;i++){
                    try {
                        share.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"AA").start();

            new Thread(()->{
                for(int i=0;i<10;i++){
                    try {
                        share.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"BB").start();

            new Thread(()->{for(int i=0;i<10;i++){
                try {
                    share.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }},"CC").start();

            new Thread(()->{
                for(int i=0;i<10;i++){
                    try {
                        share.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"DD").start();
        }
    }

}
