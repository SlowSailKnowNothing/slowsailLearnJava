package rongyao;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test4 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int[][] points=new int[5][2];
        while(sc.hasNext()){
            for(int i=0;i<5;i++){
                for(int j=0;j<2;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            double min=Integer.MAX_VALUE;
            for(int i=0;i<5;i++){
                boolean[] visited=new boolean[5];
                min=Math.min(dfs(points,visited,0,i,new int[]{0,0}),min);
            }
            System.out.println(Math.floor(min));
        }

    }

    private static double dfs(int[][] points, boolean[] visited,int count,int index,int[] pre) {
        if(count==4){
           return getDistance(points[index],new int[]{0,0});
        }
        visited[index]=true;
        double curDistance=getDistance(pre,points[index]);
        double min=Integer.MAX_VALUE;
        for(int i=0;i<5;i++){
            if(visited[i])continue;
            min=Math.min(min,dfs(points,visited,count+1,i,points[index]));
        }
        return min+curDistance;
    }

    private static double getDistance(int[] position, int[] ints) {
        int x=position[0]-ints[0];
        int y=position[1]-ints[1];
        double distance=Math.sqrt(x*x+y*y);
        return distance;
    }

}
