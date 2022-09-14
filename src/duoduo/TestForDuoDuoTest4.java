package duoduo;

import java.util.*;

public class TestForDuoDuoTest4 {
    static final int U=0;
    static final int D=1;
    static final int L=2;
    static final int R=3;
    static final int F=4;
    static final int B=5;


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            int num=sc.nextInt();
            for(int i=0;i<num;i++){
                int ans=0;
                int[] group1=new int[6];
                int[] group2=new int[6];
                Map<Integer, Integer> map1=new HashMap<Integer, Integer>();
                Map<Integer, Integer> map2=new HashMap<Integer, Integer>();
                for(int k=0;k<6;k++){
                    group1[k]=sc.nextInt();
                    if(k%2==1){
                        map1.put(group1[k],group1[k-1]);
                        map1.put(group1[k-1],group1[k]);
                    }
                }
                for(int k=0;k<6;k++){
                    group2[k]=sc.nextInt();
                    if(k%2==1){
                        map2.put(group2[k],group2[k-1]);
                        map2.put(group2[k-1],group2[k]);
                    }
                }

                for(int key:map1.keySet()){
                    if(map2.get(key)!=map1.get(key)){
                        ans=-1;
                    }
                }
                if(ans==-1){
                    System.out.println(ans);
                    continue;
                }
            //利用bfs来解题，维护一个队列，这个队列维护的就是当前的数组，然后每次将队列中的数出来，然后再和数组2进行对比
                Queue<int[]> queue=new ArrayDeque<>();
                queue.offer(group1);
                Set<int[]> set=new HashSet<>();
                //set.add(group1);

                while (!queue.isEmpty()){
                    int[] status1=queue.poll();
                    if(isSame(status1,group2)){
                        break;//表示已经找到答案了，返回ans即可
                    }else{
                        //可能会有四种操作。
                        //前转
                        int[] groupF=status1.clone();
                        int[] groupB=groupF;
                        int[] groupL=groupF;
                        int[] groupR=groupF;
                        int front=status1[F];
                        int back=status1[B];
                        int left=status1[L];
                        int right=status1[R];
                        int up=status1[U];
                        int down=status1[D];

                        groupF[D]=front;
                        groupF[B]=down;
                        groupF[U]=back;
                        groupF[F]=up;
                        queue.offer(groupF);
                        groupB[D]=back;
                        groupB[B]=up;
                        groupB[U]=front;
                        groupB[F]=down;
                        queue.offer(groupB);
                        groupL[D]=left;
                        groupL[R]=up;
                        groupL[U]=right;
                        groupL[R]=down;
                        queue.offer(groupL);
                        groupR[U]=left;
                        groupR[L]=up;
                        groupR[D]=right;
                        groupR[L]=down;
                        queue.offer(groupR);
                        // 产生4个新的状态，状态不能是重复过的，所以先判断重复，然后添加step
                        ans++;
                    }
                }

                System.out.println(ans);

            }

        }
    }

    private static boolean isSame(int[] status1, int[] group2) {
        for(int i=0; i<status1.length; i++) {
            if(status1[i]!=group2[i])return false;
        }
        return true;
    }
}
