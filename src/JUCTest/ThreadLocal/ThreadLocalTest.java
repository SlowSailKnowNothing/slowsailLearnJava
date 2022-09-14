package JUCTest.ThreadLocal;

import java.util.concurrent.TimeUnit;

class Demo{
    int num;
    public void setNum(int num){
        this.num=num;
    }

    public int getNum(){
        return this.num;
    }


}

public class ThreadLocalTest {
    static ThreadLocal<Demo> tl=new ThreadLocal<>();
    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(tl.get());
            System.out.println(Thread.currentThread().getName()+"运行结束");
        },"Thread1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Demo());
            System.out.println(Thread.currentThread().getName()+"运行结束");
        },"线程2").start();
    }
}
