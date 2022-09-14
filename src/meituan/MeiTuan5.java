package meituan;

import java.util.Scanner;

public class MeiTuan5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int[] color = new int[N];
            int[] root=new int[N];
            for(int i=0;i<N;i++){
                color[i]=sc.nextInt();
            }
            int whiteCount=0;
            int blackCount=0;
            for(int i=0;i<N;i++){
                root[i]=sc.nextInt();
                if(root[i]==0)continue;
                if(color[root[i]]==1){//如果i的父节点是黑色，若该节点没有子节点，或该节点的所有子节点均为白色节点，则该节点是好节点
                      if(color[i]==1)color[root[i]]=2;//2标注为不是好节点
                }else if(color[root[i]]!=3){
                    if(color[i]==1){ //至少有一个黑色节点
                        whiteCount++;
                        color[root[i]]=3;//标注这个已经计数了
                    }else{
                        color[root[i]]=4;
                    }
                }
            }

            for(int num:color){
                if(num==0)whiteCount++;
                if(num==1)blackCount++;
            }
            System.out.print(whiteCount);
            System.out.print(blackCount);


        }
    }
}
