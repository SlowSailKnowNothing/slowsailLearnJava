package leetcodeTest;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode224Test {
    public static void main(String[] args) {
        restoreIpAddresses("255255255255");
    }

    public static int calculate(String s) {
        return 0;
    }

    public static int calculateIpNum(String ipStr){
        int ans=0;
        String[] ipNum=ipStr.split("\\.");
        for(int i=0;i<ipNum.length;i++){
            ans=ans+(int)Math.pow(256,3-i);
        }
        return ans;
    }


    //注意while和if的区别，这个自己一定要注意，老是喜欢将while写成if
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> myQue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        int i=0;
        for(;i<k-1;i++){
            add(i,myQue,nums);
        }
        for(;i<nums.length;i++){
            add(i,myQue,nums);
            pop(i,k,myQue);
            list.add(nums[myQue.peekFirst()]);
        }

        int[] ans=new int[list.size()];
        for( i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }

    public static void add(int numIndex, Deque<Integer> myQue, int[] nums){
        while(!myQue.isEmpty()&&nums[myQue.peekLast()]<=nums[numIndex]){
            myQue.pollLast();
        }
        myQue.offerLast(numIndex);
    }

    public static void pop(int numIndex,int k,Deque<Integer> myQue){
        while(!myQue.isEmpty()&&myQue.peekFirst()<numIndex-k+1){
            myQue.pollFirst();
        }
    }


    public static int maxProduct(int[] nums) {
        int iMax=1;
        int iMin=1;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(num<0){
                iMax=Math.max(num,iMin*num);
                iMin=Math.min(num,iMax*num);//这里错误，因为iMax在上面的步骤中被更改了
            }else{
                iMax=Math.max(num,iMax*num);
                iMin=Math.min(num,iMin*num);//这里之前写成max了
            }
            max=Math.max(iMax,max);
        }
        return max;
    }

    public static  List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList<>();
        dfs(0,new StringBuilder(),s,0,ans);
        return ans;
    }


    public static void dfs(int index,StringBuilder sb,String s,int step,List<String> ans){
        if(step>4)return;
        if(step==4&&index==s.length()){
            ans.add(sb.deleteCharAt(sb.length()-1).toString());
            return;
        }
        for(int start=index;start<s.length();start++){
            for(int offset=1;offset<=3;offset++){
                int end=offset+start;
                if(end>s.length())break;
                String str=s.substring(start,end);
                if(Integer.parseInt(str)>255)break;
                sb.append(str).append(".");   //这是自己做回溯经常做错的点，就是添加了但是每次就是忘记了删除
                dfs(end,sb,s,step+1,ans);
                
            }
        }
    }
}
