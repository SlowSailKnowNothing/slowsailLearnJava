package duoduo;

import java.util.Scanner;

public class TestForDuoDuoTest1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            char[] str=sc.nextLine().toCharArray();
            StringBuilder sb=new StringBuilder();
            int point=0;
           while(point < str.length){
                char ch=str[point];
                int count=1;
                while(point<str.length-1&&ch==str[point+1]){
                    point++;
                    count++;
                }
                point++;
                sb.append(count).append(ch);
            }
            System.out.println(sb);
        }
    }
}
