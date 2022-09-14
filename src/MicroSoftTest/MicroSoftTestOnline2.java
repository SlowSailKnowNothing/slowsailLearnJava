package MicroSoftTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MicroSoftTestOnline2 {
    public static void main(String[] args) {

    }


    public static int getMin(int[] A,int[] B){
        HashSet<Integer> set = new HashSet<Integer>();
        int[] sortArray = new int[A.length];
        for(int i=0;i<A.length;i++){
            int num;
            if(set.contains(A[i])){
                num=A[i];
            }else if(set.contains(B[i])){
                num=B[i];
            }else{
                num=Math.max(A[i],B[i]);
                set.add(num);
            }
            int index=num-1;

            if(index>=0&&index<A.length&&sortArray[index]!=num){
               sortArray[index]=num;
            }

        }
        for(int i=0;i<A.length;i++){
            if(sortArray[i]!=i+1)return i+1;
        }
        return A.length+1;
    }

    public void swap(int[] sortArray,int index1,int index2){
        int temp=sortArray[index2];
        sortArray[index2]=sortArray[index1];
        sortArray[index1]=temp;
    }


    public static int getLen(String s){
        int len=s.length();
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int mask=0;
        map.put(0,-1);

        int ans=0;

        for(int i=0;i<len;i++){
            int val=s.charAt(i)-'0';
            mask^=(1<<val);
            if(map.containsKey(mask)){
                ans=Math.max(ans,i-map.get(mask));
            }else{
                map.put(mask,i);
            }
        }
        return ans;
     }
}
