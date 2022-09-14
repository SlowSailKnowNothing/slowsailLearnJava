package RedBook;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            List<List<Integer>> list=new ArrayList<>();
            int len=scanner.nextInt();
            for(int i=0;i<=len;i++){
                list.add(new ArrayList<>());
            }
            for(int i=1;i<len;i++){
                int num1=scanner.nextInt();
                list.get(num1).add(i+1);
                list.get(i+1).add(num1);
            }
           // Collections.sort(list, Comparator.comparingInt(List::size));
            int ans=0;
            boolean[] isRemove=new boolean[list.size()];
//            for(List<Integer> li:list){
//                if()
//                for(int index=0;index<li.size();index++){
//                    int num=li.get(index);
//                    isRemove[num]=true;
//                    ans++;
//                }
//            }

            for(int i=0;i<list.size();i++){
                if(isRemove[i])continue;
                List<Integer> li=list.get(i);
                for(int index=0;index<li.size();index++){
                    int num=li.get(index);
                    isRemove[num]=true;
                    ans++;
                    break;  //少想一个dfs
                }
            }
            System.out.println(ans);

        }
    }
}
