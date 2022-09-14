package rongyao;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat dc=new DecimalFormat("0.00");
        int compare1=1024;
        int compare2=1024*1024;
        int compare3=compare1*compare2;
        int compare4=compare3*compare1;
//        while(scanner.hasNext()){
//            int num=scanner.nextInt();
//            if(num<compare1) System.out.println(dc.format(num)+"B");
//            else if(num<compare2){
//                System.out.println(dc.format(num/1024.0)+"KB");
//            }else if(num<compare3){
//                System.out.println(dc.format(num/1024.0/1024.0)+"MB");
//            }else if(num<compare4){
//                System.out.println(dc.format(num/1024.0/1024.0/1024.0)+"GB");
//            }
//        }
        System.out.println(Integer.MAX_VALUE);
    }
}
