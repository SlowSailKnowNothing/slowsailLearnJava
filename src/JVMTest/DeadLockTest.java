package JVMTest;

public class DeadLockTest {
    static Object resource1=new Object();
    static Object resource2=new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized(resource1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(resource2){
                    System.out.println(Thread.currentThread() + "get resource2");
                }


            }
        },"thread1").start();

        new Thread(()->{
                synchronized(resource2){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(resource1){
                        System.out.println(Thread.currentThread()+"get resource1");
                    }
                }
        },"thread2").start();
    }
}
