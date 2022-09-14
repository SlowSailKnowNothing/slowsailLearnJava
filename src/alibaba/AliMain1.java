package alibaba;

import java.util.*;

public class AliMain1 {

    static class Pair{
        int point1;
        int point2;
        Pair(int point1, int point2){
            this.point1 = point1;
            this.point2 = point2;
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return point1 == pair.point1 &&
                    point2 == pair.point2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(point1, point2);
        }
    }
    static int max=0;
    //public static List<List<Integer>> ans=new ArrayList<>();
    static int[][] ans=new int[3][3];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int T=sc.nextInt();
            sc.nextLine();
            for(int it=0;it<T;it++){
               // List<StringBuilder> listInitial=new ArrayList<StringBuilder>();
                max=0;
                int[][] matrix=new int[3][3];

                List<int[]> emptyList=new ArrayList<int[]>();
                for(int j=0;j<3;j++){
                    String s=sc.nextLine();
                    char[] charArray=s.toCharArray();
                    for(int i=0;i<3;i++){
                        char ch=charArray[i];
                        if(ch!='*')
                        matrix[j][i]=charArray[i]-'0';
                        else {
                            matrix[j][i]=0;
                            emptyList.add(new int[]{j,i});
                        }
                    }
                }//建立基本的矩阵

                List<HashSet<Pair>> setList=new ArrayList<HashSet<Pair>>();
                //List<HashMap<Integer,Integer>> mapList=new ArrayList<>();
                for(int k=0;k<3;k++){
                    HashSet<Pair> set=new HashSet<Pair>();
                    for(int l=0;l<3;l++){
                        int x=sc.nextInt();
                        int y=sc.nextInt();
                        set.add(new Pair(x,y));
                    }
                    setList.add(set); //可以根据set判断是在哪一个组
                    //mapList.add(new HashMap<Integer,Integer>());//判断是哪个组后根据map判断是否重复
                }
                //两个行列的二维数组
                boolean[][] col=new boolean[3][3];
                boolean[][] row=new boolean[3][3];
                boolean[][] block=new boolean[3][3];


                for(int j=0;j<3;j++){
                    for(int l=0;l<3;l++){
                        int num=matrix[j][l];
                        if(num!=0){
                            row[j][num-1]=true;
                            col[l][num-1]=true;
                            for(int i=0;i<3;i++){
                                if(setList.get(i).contains(new Pair(j,l))){
                                        block[i][num-1]=true;
                                }
                            }
                        }
                    }
                }// 进行初始化

                dfs(matrix,col,row,block,setList,emptyList,0);
                if(max==1){
                    System.out.println("Unique");
                    for(int i=0;i<3;i++){
                        for(int j=0;j<3;j++)
                        {
                            System.out.print(ans[i][j]);

                        }
                        System.out.println();

                    }
                }else if(max==0){
                    System.out.println("No");
                }else{
                    System.out.println("Multiple");
                }



                sc.nextLine();
            }


        }
    }

    private static void dfs(int[][] matrix,boolean[][] col, boolean[][] row, boolean[][] block, List<HashSet<Pair>> setList, List<int[]> emptyList, int index) {
        if(index==emptyList.size()){
            max++;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                   ans[i][j]=matrix[i][j];
                }
            }
            return;
        }

        for(int i=index;i<emptyList.size();i++){//每次找到一个位置
            for(int j=0;j<3;j++){
                int[] point=emptyList.get(i);//每次取出一个位置
                //根据point要求出对应的block
                int blockNum=0;
                for(int k=0;k<3;k++){
                    if(setList.get(k).contains(new Pair(point[0],point[1]))){
                        blockNum=k;
                        break;
                    }
                }
                if(row[point[0]][j]==true||col[point[1]][j]==true||block[blockNum][j])continue;
                else{
                    row[point[0]][j]=true;
                    col[point[1]][j]=true;
                    block[blockNum][j]=true;
                    //setList.get(blockNum).add(new Pair(point[0],point[1]));
                    matrix[point[0]][point[1]]=j+1;
                    dfs(matrix,col,row,block,setList,emptyList,index+1);
                    row[point[0]][j]=false;
                    col[point[1]][j]=false;
                    block[blockNum][j]=false;
                    //setList.get(blockNum).remove(new Pair(point[0],point[1]));
                }
            }
        }



    }
}
