package meituan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MeiTuan4 {
    public static void main(String[] args) {
        //思路就是每次挑选从当前开始最晚出现的那个，优先选没有出现的，然后选最晚出现的
        //维护n个列表，然后每个列表记录都是出现的时间，然后每次出现炸弹的时候，选择空列表或者是列表头最小的，然后被选中就将节点删除

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N=sc.nextInt();
            int M=sc.nextInt();
            List<List<Integer>> list=new ArrayList<>();
            int[] arr=new int[M];
            for(int i=0; i<N; i++) {
                list.add(new LinkedList<>());
            }
            for(int i=0; i<M; i++) {
                int num=sc.nextInt();
                arr[i]=num-1;
                list.get(num-1).add(i);//i相当于时间，房间号时因为从0开始的嘛
            }

            int position=0;//房间都减去1
            int count=0;
            for(int i=0;i<arr.length;i++) {
                int second=i;
                if(position==arr[i]){
                    count++;
                    for(int j=0;j<list.size();j++){
                        if(j==position)continue;
                        if(list.get(j).size()==0){
                            position=j;
                            break;
                        };
                        int num=list.get(j).get(0);//注意，这里返回的是秒数
                        if(num>second){
                            second=num;//更新秒数
                            position=j;//更新位置
                        }
                    }
            }
                list.get(arr[i]).remove(0);

        }
            System.out.println(count);

        }
    }
}
