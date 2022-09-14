package JUCTest;


import java.util.concurrent.Callable;

class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for(int i=0;i<10000;i++){
            sum+=i;
        }
        return sum;
    }
}
public class TestCall {
    public static void main(String[] args) {
        Task task = new Task();
        Integer sum=0;
        try {
            Integer call = task.call();
            sum=call;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sum); //也是可以直接调用call方法的

    }
}
