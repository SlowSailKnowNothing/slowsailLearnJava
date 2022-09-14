package designPattern;

public class sigletonTest {
    public static void main(String[] args) {
        SigletonClass sigletonClassTest=SigletonClass.getSigletonClass();
        System.out.println(sigletonClassTest.name);
    }
    
    public static class SigletonClass{
        private static volatile SigletonClass sigletonClass;
        static String name="testName";

        private SigletonClass() {
        }

        public static SigletonClass getSigletonClass() {
            if(sigletonClass == null){
                synchronized(SigletonClass.class){
                    if(sigletonClass==null){
                        sigletonClass = new SigletonClass();
                    }
                }
            }

            return sigletonClass;
        }
    }
}
