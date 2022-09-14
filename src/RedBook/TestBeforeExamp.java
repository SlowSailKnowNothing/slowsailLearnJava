package RedBook;

import java.util.Scanner;

public class TestBeforeExamp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            int n=sc.nextInt();
            //double
            int m=sc.nextInt();
            double ans=0;
            for(int i=0;i<m;i++){
                ans+=n;
                //n=Math.sqrt(n);
            }

        }


    }
}
