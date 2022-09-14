package duoduo;


import java.util.Arrays;
import java.util.Scanner;

// 对多多攻排序，对皮皮守排序，先做满足攻击》守的条件下，
//守的从大的守开始进行求解，先找出攻的中，能战胜守的攻的最小的数（所以维护一个多多的攻）
/*
1.对多多攻排序（从大到小，然后守对应是从大到小），对皮皮守排序，攻对应是从大到小。
2.然后逐次贪心挑出对应的去对战皮皮，然后计算最后返回的值。
*/
public class TestForDuoDuoTest3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            int N=sc.nextInt();
            int M=sc.nextInt();
            int[][] duoduo=new int[N][2];
            int[][] pipi=new int[M][2];

            for(int i=0;i<N;i++){
                duoduo[i][0]=sc.nextInt();
                duoduo[i][1]=sc.nextInt();
            }

            for(int i=0;i<M;i++){
                pipi[i][0]=sc.nextInt();
                pipi[i][1]=sc.nextInt();
            }

            Arrays.sort(duoduo,(a1,a2)->{
                return a2[0]==a1[0]?a2[1]-a1[1]:a2[0]-a1[0];
            });
            Arrays.sort(pipi,(a1,a2)->{
                return a2[0]==a1[0]?a2[1]-a1[1]:a2[0]-a1[0];
            });

            System.out.println(duoduo);
            System.out.println(pipi);

            int ans=0;
            boolean[] used=new boolean[N];//记录已经出征过的duoduo军团
            for(int i=0;i<M;i++){
                //遍历每一个pipi军团
                for(int j=0;j<N;j++){
                    if(used[j]==true)continue;
                    if(pipi[i][1]>=duoduo[j][0]){
                        ans=-1;
                        break;
                    }else{
                        //满足攻击力要求，现在要尽力找防守符合要求的
                        if(pipi[i][1]<=duoduo[j][1])ans++;
                        else;

                    }
                }
                if(ans==-1)break;
            }
            System.out.println(ans);

        }
    }
}
