package JUCTest.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Share2{
    int num=0;

    Lock lock=new ReentrantLock();
    Condition condition1=lock.newCondition();
    Condition condition2=lock.newCondition();
    Condition condition3=lock.newCondition();
    public void add5(){
        lock.lock();
        try{
            while(num!=0){
                condition1.await();
            }
            for(int i=0;i<5;i++){
                num++;
            }
            condition2.signal();
        }catch(Exception e){

        }finally {
            lock.unlock();
        }
    }
}
public class ThreadDemo3 {

}
