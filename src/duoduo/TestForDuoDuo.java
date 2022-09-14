package duoduo;

import java.util.Scanner;

public class TestForDuoDuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            boolean[] visited = new boolean[9];//0可以不用考虑，因为0一定不是最小值 1-9
            //int begin=1;
            String num=dfs(visited,N,new StringBuilder());
            System.out.println(num);
        }
    }

    public static String dfs(boolean[] visited,int target,StringBuilder sb){
        if(target==0) return sb.reverse().toString();
        if(target<0)return "-1";
            for(int i=9;i>=1;i++){
                if(visited[i-1]==true)continue;
                sb.append(i);// 添加对应的元素
                visited[i-1]=true;
                String ret=dfs(visited,target-i,sb);
                if(!ret.equals("-1"))return ret;
                visited[i-1]=false;
                sb.deleteCharAt(sb.length()-1);
            }


        return "-1";
    }
}
