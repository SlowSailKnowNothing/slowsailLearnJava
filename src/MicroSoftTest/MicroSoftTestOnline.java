package MicroSoftTest;

import java.util.*;


public class MicroSoftTestOnline {
    public static int cost;
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,1,1},new int[]{1,2,3}));
    }
//    public static int solution(int[] X, int[] Y, int W) {
//        Arrays.sort(X);
//        int count=1;
//        int begin=X[0];
//        int end=begin+W;
//        for(int i=0;i<X.length;i++){
//            if(X[i]<=end)continue;
//            begin=X[i];
//            end=begin+W;
//            count++;
//        }
//        return count;
//    }

    public static  String solution(String S) {
        char[] charArray=S.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for(char ch='0';ch<='9';ch++){
            map.put(ch,0);
        }
        for(char ch:charArray){
            map.put(ch,map.get(ch)+1);
        }
        StringBuilder ans=new StringBuilder();
        char single='a';
        for(char ch='9';ch>'0';ch--){
            int num=map.get(ch);
            if(num==0)continue;
            if(num%2==1&&single=='a')single=ch;
            int times=num/2;
            for(int i=0;i<times;i++){
                ans.append(ch);
            }
        }
        if(ans.length()==0) return single=='a'?"0":ans.append(single).toString();
        int num=map.get('0');
        if(num%2==1&&single=='a')single='0';
        int times=num/2;
        for(int i=0;i<times;i++){
            ans.append('0');
        }


        String str=ans.reverse().toString();
        return single=='a'?ans.append(str).toString():ans.append(single).append(str).toString();
    }



    static boolean[] visited = new boolean[100000];
    static int solution(int A[], int B[]) {
        //其实就是树的思路啦
        //分为两种节点，一种节点是没有其他后续的节点了，直接cost++，count++即可
        //一种节点是还有后续节点，即链表size>1，那么就要递归去求cost，同时count也是递归去求，注意count返回
        List<List<Integer>> nodeList = new ArrayList<List<Integer>>();
        int N=A.length;
        for(int i=0;i<=N;i++){
            nodeList.add(new ArrayList<Integer>());
        }

        for(int i=0;i<N;i++){
            nodeList.get(A[i]).add(B[i]);
            nodeList.get(B[i]).add(A[i]);
        }

        for(int index:nodeList.get(0)){
            visited[0]=true;
            double totalCount=(Math.ceil(dfs(index,nodeList,visited)/5.0));//注意dfs求的是各个节点到当前节点的人数，所以中间一直在累加;然后cost是一直在过程中加
            cost=cost+(int)totalCount;
        }
        return cost;
    }

    public static int dfs(int index,List<List<Integer>> nodeList,boolean[] visited){
            if(nodeList.get(index).size()==1){
                visited[index]=true;
                return 1;
            }
            int count=1;
            int singleCount=0;
            for(int num:nodeList.get(index)){
                if(visited[num])continue;
                singleCount=dfs(num,nodeList,visited);
                cost= (int) (cost+Math.ceil(singleCount/5.0));
                count+=singleCount;
            }
            return count;
    }
}
