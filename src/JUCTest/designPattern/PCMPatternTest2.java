package JUCTest.designPattern;

import java.util.Queue;

public class PCMPatternTest2 {
    public static void main(String[] args) {

    }

    public static class Producers extends Thread{
        Queue<Integer> queue;
        int count;

        public Producers(Queue<Integer> queue, int count) {
            this.queue = queue;
            this.count = count;
        }

        @Override
        public void run() {
            for(int i=0;i<count;i++){
                queue.add(i);
            }
        }
    }

    public static class Consumer extends Thread{
        Queue<Integer> queue;

        public Consumer(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {

        }
    }
}
