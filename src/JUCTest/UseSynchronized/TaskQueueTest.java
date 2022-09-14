package JUCTest.UseSynchronized;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueueTest {
    static TaskQueue myQueue = new TaskQueue();
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            try {
                System.out.println(myQueue.getTask());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        myQueue.addTask(10);

    }
}

class TaskQueue{

    Queue<Integer> queue;

    TaskQueue(){
        this.queue = new LinkedList<Integer>();
    }

    synchronized int getTask() throws InterruptedException {
        while(queue.isEmpty()) this.wait();
        return queue.remove();
    }

    synchronized void addTask(int num){
        queue.offer(num);
        this.notifyAll();
    }
}
