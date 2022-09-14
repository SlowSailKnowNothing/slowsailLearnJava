package RedBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int row=sc.nextInt();
            int colum=sc.nextInt();
            int index=sc.nextInt();//注意是真正的index+1 比如1对应的是0
            int[][] input=new int[row][colum];

            for(int i=0;i<row;i++){
                for(int j=0;j<colum;j++){
                    input[i][j]=sc.nextInt();
                }
            }
            int ans=0;
            int compare=0;
            for(int i=0;i<colum;i++){
                compare+=input[index-1][i];
            }

            for(int i=0;i<index-1;i++){
                int tryCompare=0;
                for(int j=0;j<colum;j++){
                    tryCompare+=input[i][j];
                }
                if(tryCompare>=compare)ans++;
            }

            for(int i=index;i<row;i++){
                int tryCompare=0;
                for(int j=0;j<colum;j++){
                    tryCompare+=input[i][j];
                }
                if(tryCompare>compare)ans++;
            }
            System.out.println(ans);
        }
    }
}
