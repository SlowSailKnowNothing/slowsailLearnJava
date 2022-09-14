package rongyao;

import java.util.*;

public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalMonery=scanner.nextInt();
        int row=scanner.nextInt();

    }


    public int[] topKFrequent(int[] nums,int k){
        int len=nums.length;

        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> queue=new PriorityQueue<int[]>((a,b)->{
           return a[1]-b[1];
        });

        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            int num=entry.getKey();
            int fre=entry.getValue();

            queue.offer(new int[]{num,fre});

            if(queue.size()==k+1){
                queue.poll();
            }
        }

        int[] ans=new int[k];
        int i=0;
        while(!queue.isEmpty()&&i<k){
            ans[i++]=queue.poll()[0];
        }
        return ans;
    }

    public String largestNumber(int[] nums) {
           String[] sortNums=new String[nums.length];

           for(int i=0;i<sortNums.length;i++){
               sortNums[i]=nums[i]+"";
           }

           Arrays.sort(sortNums,(a,b)->{
               //return b.compareTo(a);
               String sa=b+a;
               String sb=a+b;
               return sa.compareTo(sb);
           });

           StringBuilder sb=new StringBuilder();

           for(String str:sortNums){
               sb.append(str);
           }
           return sb.toString();
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] ans=nextGreaterElement(nums2);
            Map<Integer, Integer> map=new HashMap<Integer, Integer>();
            for(int i=0; i<nums1.length; i++){
                map.put(nums2[i],ans[i]);
            }
            int[] res=new int[nums1.length];
            for(int i=0; i<nums1.length; i++){
                res[i]=map.get(nums1[i]);
            }
            return res;
    }


    public int[] nextGreaterElement( int[] nums){
        int[] ans=new int[nums.length];
        Deque<Integer> stack=new ArrayDeque<Integer>();
        for(int i=nums.length-1; i>=0;i--){
            int num=nums[i];
            while(!stack.isEmpty()&&stack.peek()<num){
                stack.pop();
            }
            ans[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(num);//对于栈，map这种结构，一定要注意随时更新结构
        }
        return ans;
    }
}
