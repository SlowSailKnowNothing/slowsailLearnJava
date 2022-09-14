package alibaba;

import java.util.Scanner;

import java.util.*;

public class TestMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();//表示会有T组数据
            for(int i=0;i<T;i++){
                int col = sc.nextInt();//表示一行有多少列
                int[][] input = new int[2][col];//表示2行，分别表示x和y
                for (int k= 0;  k< 2; i++) {
                    for (int j = 0; j < col; j++) {
                        input[k][j] = sc.nextInt(); //想办法识别一下输入吧转换一下
                    }
                }
                //这里就得到了该组的数了



                System.out.println();
            }





        }
    }


}

