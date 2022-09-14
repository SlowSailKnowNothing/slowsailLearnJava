package webank;

import java.util.Scanner;

public class WebankTest2 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        //System.out.println(Integer.MAX_VALUE>Math.pow(10,18)); 所以要用long类型
        while (sc.hasNext()) {
            int row=sc.nextInt();
            for(int i=0;i<row;i++){
                long num1=sc.nextLong();
                long num2=sc.nextLong();
                calculate(num1,num2);
            }
        }
    }

    private static void calculate(long num1, long num2) {

        if(num1<num2){
            long temp=num2;
             num2=num1;
             num1=temp;
        }
        int offset=0;
        for(;offset<63;offset++){
            if(num2==num1)break;
            num1=num1>>1;
        }
        if(offset==63&&num2!=num1){
            System.out.println(-1);
        }else{
            //offset即为距离，现在要计算要进行几步到offset
            offset=Math.min(offset,63-offset);
            int step=0;
            if(offset>=3){
                step+=offset/3;
                offset=offset%3;
            }
            if(offset>=2){
                step+=offset/2;
                offset=offset%2;
            }

            if(offset>=1){
                step+=offset;
            }
            System.out.println(step);

        }

    }


}
