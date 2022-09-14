package study;

public class FinallyTest {
    public static void main(String[] args) {
        System.out.println(testFinally());
    }

    public static int testFinally() {
        int i = 0;
        try{
            i = 1;
            return i;
        }finally{
            i = 2;
        }
    }
}
