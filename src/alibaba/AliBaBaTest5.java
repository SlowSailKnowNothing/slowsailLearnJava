package alibaba;

import java.util.*;

public class AliBaBaTest5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[N];
        for (int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(new ArrayList<Integer>());
        }

        for(int i=0; i<N-1; i++){
            int x=sc.nextInt();
            int y=sc.nextInt();// 注意下标减去1
            list.get(x).add(y);
            list.get(y).add(x);// 列表组合
        }
        Queue<Integer> queue=new ArrayDeque<>();
        int[] vis=new int[N];//注意，这个vis是全局的，因为默认一次遍历其实就会将最近的找到，这算是一个trick的点还，但是其实bfs还是记忆一下，一般遍历过的点本来就不应该继续遍历
        int res=0;
        for(int i=0;i<N;i++){
            //每次选取一个节点，放入队列，然后向周围扩散
            queue.offer(i);
            int step=0;
            while(!queue.isEmpty()){
                int index=queue.poll();
                //int key=arr[index];
//                for(int num:list.get(key)){
//                        queue.offer(num);// 如果
//                }
                step++;
            }
        }
    }
}
