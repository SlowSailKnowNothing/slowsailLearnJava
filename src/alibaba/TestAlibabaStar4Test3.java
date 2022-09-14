package alibaba;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class TestAlibabaStar4Test3 {

    public static int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public static int minTimes = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] matrix = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            int[] start = new int[2];
            int[] end = new int[2];
            for (int i = 0; i < N; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < M; j++) {
                    char ch = line.charAt(j);
                    if (ch == 'S') {
                        start[0] = i;
                        start[1] = j;
                    } else if (ch == 'E') {
                        end[0] = 'i';
                        end[1] = 'j';
                    }
                    matrix[i][j] = ch;
                }
            }

            getMinTimes(matrix, 5, start, end, visited, 0);
            System.out.println(minTimes);
        }
    }

    public static void getMinTimes(int[][] matrix, int air, int[] start, int[] end, boolean[][] visited, int times) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(start);
    }

//        while(!queue.isEmpty()){
//            int[] cur=queue.poll();
//            if(cur[0]==end[0]&&cur[1]==end[1]){
//                minTimes=Math.min(minTimes,times);
//            }
//            int[] nextCur=new int[2];
//            for(int i=0;i<4;i++){
//                nextCur[0]=cur[0]+directions[i][0];
//                nextCur[1]=cur[1]+directions[i][1];
//                if(isValid(nextCur,matrix,visited))queue.add(nextCur);//完全不用将visited，只需要将目标转换为#即可
//            }
//            //也可能使用飞行器
//            if(air>0){
//                nextCur[0]=matrix.length-cur[0];
//                nextCur[1]=matrix[0].length-cur[1];
//                if(isValid(nextCur,matrix,visited))//判断是否经过visited，判断是否越界
//                getMinTimes(matrix,air-1,nextCur,end,visited,times+1);
//            }
//
//            times++;
//        }
//    }
//}
}