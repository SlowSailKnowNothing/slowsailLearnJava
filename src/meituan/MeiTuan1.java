package meituan;

import java.util.Scanner;

public class MeiTuan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            for(int i = 0; i < N; i++) {
                long num=sc.nextLong();
                if(num%11==0||count2(num)) System.out.println("Yes");
                else System.out.println("No");

            }
        }
    }

    private static boolean count2(long num) {
       String str=num+"";
       int count=0;
       for(char ch:str.toCharArray()){
           if(ch=='1'){
               count++;
               if(count>=2)return true;
           }
       }
       return false;
    }
}
