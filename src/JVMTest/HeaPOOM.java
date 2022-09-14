package JVMTest;

import java.util.ArrayList;
import java.util.List;

public class HeaPOOM {
    static class TestObject{

    }
    public static void main(String[] args) {
        List<TestObject> list=new ArrayList<TestObject>();
        while(true){
            list.add(new TestObject());
        }
    }
}
