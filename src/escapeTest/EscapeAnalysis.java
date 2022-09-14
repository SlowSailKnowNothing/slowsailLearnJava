package escapeTest;

public class EscapeAnalysis {
    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            myClass myClass = new myClass();
        }

        while(1==1);
    }

    public static class myClass{
        int a;
        int b;
        myClass(){};
    }
}
