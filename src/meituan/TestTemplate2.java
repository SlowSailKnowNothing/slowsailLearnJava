package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class TestTemplate2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int row = sc.nextInt();
            sc.nextLine();
            char[] str1=sc.nextLine().toCharArray();
            char[] str2=sc.nextLine().toCharArray();
            System.out.println(str1);
            System.out.println(str2);
            Arrays.sort(str1);
            Arrays.sort(str2);

            int count=0;

            for(int i=0;i<str1.length;i++) {
                count+=Math.abs(str1[i] - str2[i]);
            }
            System.out.println(count);
        }
    }
}
