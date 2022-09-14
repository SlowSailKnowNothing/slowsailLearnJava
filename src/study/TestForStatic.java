package study;

public class TestForStatic {
    public static void main(String[] args) {
        System.out.println(TestClass1.testNum);
    }

    public static class TestClass1{
        public static int testNum=1;
    }
}
