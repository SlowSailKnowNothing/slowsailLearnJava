package webank;

import java.util.Scanner;

public class WebankTest3 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        for(int i=10;i<100;i++){
            System.out.println(i+":"+(Math.pow(10,18)>Math.pow(2,i)?"big":"small"));
        }

    }
}
