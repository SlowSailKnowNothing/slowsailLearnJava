package JUCTest.Lock;

import sun.security.krb5.internal.Ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lTicketSale {
    public static class Ticket{
        int num=30;
        int num1=0;

        public void saleTicket(){
            final Lock lock=new ReentrantLock();
            lock.lock();
            try{
                System.out.println("获得锁开始售票");
                num--;
                System.out.println("当前的票数为："+num);
            }catch(Exception e){

            }finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        Ticket ticket=new Ticket();

        new Thread(()->{
            for(int i=0;i<10;i++){
                ticket.saleTicket();
            }
        }).start();

        new Thread(()->{for(int i=0;i<10;i++){
            ticket.saleTicket();
        }}).start();


    }
}
