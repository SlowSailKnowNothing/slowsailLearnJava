package meituan;

import java.util.*;

public class MeiTuan3 {
    static int max=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int M=sc.nextInt(); //1-M菜
            List<Integer[]> list=new ArrayList<Integer[]>();
            for(int i=0; i<N; i++) {
                int n=sc.nextInt();
                int m=sc.nextInt();
                if(n<=M&&m<=M&&n>=1&&m>=1)
                list.add(new Integer[]{n,m});
            }
            Set<Integer> set=new HashSet<Integer>();
            int count=0;
            int index=0;
            dfs(list,set,count,index);
            System.out.println(max);
            max=0;
        }
    }

    private static void dfs(List<Integer[]> list, Set<Integer> set, int count,  int index) {
        max=Math.max(max,count);
        if(index==list.size()){
            return;
        }

        for(int i=index;i<list.size();i++){
            Integer a=list.get(i)[0];
            Integer b=list.get(i)[1];
            if(set.contains(a)||set.contains(b)){
                continue;//已经在上一轮中被使用了，继续
            }else{
                set.add(a);
                set.add(b);
                dfs(list,set,count+1,index+1);
                set.remove(a);
                set.remove(b);
            }

        }
    }


}
