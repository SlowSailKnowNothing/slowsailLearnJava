package JUCTest.designPattern;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class PCMPatternTest { //生产者消费者模式

    public static void main(String[] args) {
        MyBlockingQueueTest testQueue = new MyBlockingQueueTest(new LinkedList<Integer>(),10);
        Consumer consumer = new Consumer(testQueue);
        Producer producer = new Producer(testQueue);
    }



    public static class Consumer extends Thread{
        private  MyBlockingQueueTest queue;

        public Consumer(MyBlockingQueueTest queue) {
            this.queue=queue;
        }

        @Override
        public void run() {
            while(true){
                int val= 0;
                try {
                    val = queue.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(val);
            }
        }
    }

    public static class Producer extends Thread{
        private MyBlockingQueueTest queue;
        public Producer(MyBlockingQueueTest queue){
            this.queue=queue;
        }

        @Override
        public void run() {
            for(int i = 0; i <10;i++){
                try {
                    queue.add(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static class MyBlockingQueueTest{
        private int maxSize;

        private LinkedList<Integer> queue;

        public MyBlockingQueueTest(LinkedList<Integer> queue, int maxSize) {
            this.queue = new LinkedList<Integer>();
            this.maxSize = maxSize;
        }

        public  synchronized void add(int i) throws InterruptedException {
            if(queue.size()==maxSize){
                wait();
            }else{
                notifyAll();
            }
            queue.offer(i);
        }

        public synchronized int get() throws InterruptedException {
            if(queue.size()==0){
                wait();
            }else{
                notifyAll();
            }
            return queue.poll();

        }
    }
}
