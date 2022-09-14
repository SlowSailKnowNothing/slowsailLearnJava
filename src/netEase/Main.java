package netEase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Integer> ansList=new ArrayList<Integer>();
    static int max=0;
    public static void main(String[] args) {
        int packageSize=6;
        int wakeTime=10;
        int[][] treasureInfo={{1,2,4,3},{2,3,2,2},{3,4,1,4}};
        getTreasures(packageSize,wakeTime,treasureInfo);
    }

    public static int[] getTreasures(int packageSize, int wakeTime, int[][] treasureInfo) {
        // write code here
        dfs(packageSize,wakeTime,treasureInfo,0,0,new ArrayList());
        int[] ans=new int[ansList.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=ansList.get(i);
        }
        return ans;
    }
    public static void dfs(int packageSize, int wakeTime, int[][] treasureInfo, int index, int val, List<Integer> list){
        /*
        base case
        */
        if(index==treasureInfo.length){
            if(val>max){
                max=val;
                ansList.clear();
                for(int num:list){
                    ansList.add(num);
                }
            }
            return;
        }
        for(int i=index;i<treasureInfo.length;i++){
            if(treasureInfo[i][1]<=wakeTime&&treasureInfo[i][2]<=packageSize){
                    list.add(treasureInfo[i][0]);
                    dfs(packageSize-treasureInfo[i][2],wakeTime-treasureInfo[i][1],treasureInfo,i+1,val+treasureInfo[i][3],list);
                    list.remove(list.size()-1);
            }
        }


    }
}
