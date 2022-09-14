package huawei.practice;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int row=scanner.nextInt();
            int col=scanner.nextInt();
            int[][] map=new int[row][col];
            int[] start=new int[2];
            int[] end=new int[2];
            boolean[][] visited=new boolean[row][col];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    map[i][j]=scanner.nextInt();
                    if(map[i][j]==2){
                        start[0]=i;
                        start[1]=j;
                        visited[i][j]=true;
                    }

                }
            }
            int min=dfs(map,start,0,visited);
            System.out.println(min);
        }
    }

    public static int dfs(int[][] map,int[] cur,int step,boolean[][] visited){
        int x=cur[0];
        int y=cur[1];

        if(map[x][y]==3){
            System.out.println("step is"+step);
            return step;
        }
        int[][] next=new int[4][2];
        int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<4;i++){
            int[] direction=directions[i];
            next[i][0]=cur[0]+direction[0];
            next[i][1]=cur[1]+direction[1];
        }

        if(map[x][y]==4){
            step=step+3;
        }else if(map[x][y]==6){
            for(int i=0;i<4;i++){
                int nextX=next[i][0];
                int nextY=next[i][1];
                if(nextX>=0&&nextX<map.length&&nextY>=0&&nextY<map[0].length&&map[nextX][nextY]==1){
                    map[nextX][nextY]=0;
                }
            }
        }
        int min=Integer.MAX_VALUE;

        for(int i=0;i<4;i++){
            int nextX=next[i][0];
            int nextY=next[i][1];
            if(nextX>=0&&nextX<map.length&&nextY>=0&&nextY<map[0].length&&map[nextX][nextY]!=1&&visited[nextX][nextY]==false){
                visited[nextX][nextY]=true;
                min=Math.min( dfs(map,next[i],step+1,visited),min);
                visited[nextX][nextY]=false;
            }
        }

        return min;

    }



}
