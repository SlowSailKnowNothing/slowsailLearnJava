package JUCTest.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MultiLock{
    int num=0;
    Lock lock=new ReentrantLock();
    void add(){
        try{
            lock.lock();
            num++;
            System.out.println(Thread.currentThread().getName()+"num:"+num);
            try{
                lock.lock();
                num++;
                System.out.println(Thread.currentThread().getName()+"num:"+num);
            }finally{
                lock.unlock();
            }
        }catch (Exception e){

        }finally{
            lock.unlock();
        }
    }
}
public class ThreadDemo4 {

    public static void main(String[] args) {
        MultiLock multiLock=new MultiLock();
        new Thread(()->{
            multiLock.add();
        }).start();
    }
}
