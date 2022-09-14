package rongyao;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.math.*;
public class Test2 {
    public static double distance;
    public static void main(String[] args) {
        //贪心，在每个点都找和这个点最近的点，注意对访问过的点进行标记不再访问
        Scanner sc=new Scanner(System.in);
        DecimalFormat dc=new DecimalFormat("0");
        int[][] points=new int[5][2];
        while(sc.hasNext()){
            for(int i=0;i<5;i++){
                for(int j=0;j<2;j++){
                    points[i][j]=sc.nextInt();
                }
            }

            boolean[] visited=new boolean[5];
            dfs(points,visited,0,-1);
            System.out.println(dc.format(Math.floor(distance)));
        }

    }

    private static void dfs(int[][] points, boolean[] visited,int count,int index) {
        if(count==5){
            distance+=getDistance(points[index],new int[]{0,0});
            return ;
        }
        double twoDis=Double.MAX_VALUE;
        int curIndex=-1;
        double curDis=0;
        for(int i=0;i<5;i++){
            if(index!=-1){
                visited[index]=true;
            }
            if(visited[i])continue;
            if(index==-1){
                curDis=getDistance(new int[]{0,0},points[i]);
            }else{
                curDis=getDistance(points[index],points[i]);
            }
            if(curDis<twoDis){
                twoDis=curDis;
                curIndex=i;
            }
        }
        distance+=twoDis;

        dfs(points,visited,count+1,curIndex);


    }

    private static double getDistance(int[] position, int[] ints) {
        int x=position[0]-ints[0];
        int y=position[1]-ints[1];
        double distance=Math.sqrt(x*x+y*y);
        return distance;
    }


}
