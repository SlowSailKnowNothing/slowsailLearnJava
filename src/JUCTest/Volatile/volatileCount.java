package JUCTest.Volatile;


class myData{

    volatile int count=0;
    public  void add(){
        count++;
    }
    public myData(){};
}

public class volatileCount {

    public static void main(String[] args) {
        myData data=new myData();
        new Thread(()->{
            for(int i=0;i<100000;i++){
                data.add();

            }
        },"aa").start();

        new Thread(()->{
            for(int i=0;i<100000;i++){
                data.add();
            }
        },"bb").start();
        while(Thread.activeCount() > 2) {
            Thread.yield();
        }
            System.out.println(data.count);
    }
}
