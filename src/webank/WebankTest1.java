package webank;

import java.util.Arrays;
import java.util.Scanner;

public class WebankTest1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int len = sc.nextInt();
            int maxRange=sc.nextInt();
            if(maxRange<3||len<3){
                System.out.println(0);
            }

        }
    }
}
