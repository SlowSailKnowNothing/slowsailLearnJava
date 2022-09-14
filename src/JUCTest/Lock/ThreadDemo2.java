package JUCTest.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class  Share{
    private int num=0;

    private Lock lock=new ReentrantLock();

    Condition condition=lock.newCondition();

    public void increment(){
        lock.lock();
        try{
            while(num!=0){
                condition.await();//相当于信号量
                System.out.println("increment while");
            }
            num=num+1;
            System.out.println(Thread.currentThread().getName() + ":"+num);
            condition.signalAll();
        }catch(Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try{
            while(num!=1){
                condition.await();
                System.out.println("decrement while");
            }
            num=num-1;
            System.out.println(Thread.currentThread().getName() + ":"+num);
            condition.signalAll();
        }catch(Exception e){

        }finally {
            lock.unlock();
        }
    }


}
public class ThreadDemo2 {


    public static void main(String[] args) {
        Share share = new Share();
        System.out.println("开始main");
        new Thread(()->{
            for(int i=0;i<10;i++){
                share.increment();
            }
        },"aa").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                share.increment();
            }
        },"bb").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                share.decrement();
            }
        },"cc").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                share.decrement();
            }
        },"dd").start();
    }
}
