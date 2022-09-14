package duoduo;

import java.util.Arrays;
import java.util.Scanner;

public class TestForDuoDuo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int col = sc.nextInt();
            int div=sc.nextInt();
            int[] total=new int[col+1];
            total[0]=0;
            for(int i=0;i<col;i++){
                total[i+1]=total[i]+sc.nextInt();
            }
            int count=0;
            for(int start=0;start<total.length;start++){
                for(int end=start+1;end<total.length;end++){
                    if((total[end]-total[start])%div==0)count++;
                }
            }
            System.out.println(count);

        }
    }
}
