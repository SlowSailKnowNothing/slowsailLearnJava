package leetcodeTest;

public class spiralTest {
    public static int[] spiralOrder(int[][] matrix) {
        /*
        1.设计方向，0-右 1-下 2-左 3-上
        2.visited表示访问过了
        3.边界判断：访问过以及越界
        */
        if(matrix==null||matrix[0].length==0)return new int[0];

        int row=matrix.length;
        int col=matrix[0].length;

        int count=0;
        int sum=row*col;

        int i=0;
        int j=0;
        int[] ans=new int[sum];
        boolean[][] visited=new boolean[row][col];
        visited[0][0]=true;
        int direction=0;
        while(count<sum){
            ans[count]=matrix[i][j];
            switch(direction){
                case 0:{
                    if(j+1<col&&visited[i][j+1]==false){
                        j++;
                        visited[i][j]=true;
                        count++;
                    }else{
                        direction=(direction+1)%4;
                    }
                    break;
                }
                case 1:{
                    if(i+1<row&&visited[i+1][j]==false){
                        i++;
                        visited[i][j]=true;
                        count++;
                    }else{
                        direction=(direction+1)%4;
                    }
                    break;
                }
                case 2:{
                    if(j-1>=0&&visited[i][j-1]==false){
                        j--;
                        visited[i][j]=true;
                        count++;
                    }else{
                        direction=(direction+1)%4;
                    }break;
                }
                case 3:{
                    if(i-1>=0&&visited[i-1][j]==false){
                        i--;
                        visited[i][j]=true;
                        count++;
                    }else{
                        direction=(direction+1)%4;
                    }break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix=new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matrix[i][j]=i+j;
            }
        }

        int[] count=spiralOrder(matrix);
    }
}
