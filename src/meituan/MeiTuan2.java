package meituan;

import java.util.Scanner;

public class MeiTuan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N=sc.nextInt();
            int[] arr=new int[N];
            for(int i=0;i<N;i++){
                int  num=sc.nextInt();
                if(num==-1){
                    if(i>0)arr[i]=arr[i-1]+1;
                    else arr[i]=1;
                }else{
                    arr[i]=arr[i-1];
                }
            }

            int leftPoint=0;
            int count=0;
            while(leftPoint<N){
                if(arr[leftPoint]%2==0)count++;
                int rightPoint=leftPoint+1;
                while(rightPoint<N){
                    if((arr[rightPoint]-arr[leftPoint])%2==0)count++;
                    rightPoint++;
                }
                leftPoint++;
            }
            System.out.println(count);


        }
    }
}
