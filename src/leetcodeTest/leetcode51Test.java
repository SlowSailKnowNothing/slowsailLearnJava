package leetcodeTest;

public class leetcode51Test {
    public static void main(String[] args) {

    }

    public static int reversePairs(int[] nums) {
        int len=nums.length;
        if(len<2)return 0;
        int[] copy=new int[len];
        for(int i=0;i<len;i++){
            copy[i]=nums[i];
        }

        int[] temp=new int[copy.length];

        return reversePairs(copy,temp,0,len-1);
    }

    public static int reversePairs(int[] nums,int[] temp,int left,int right){
        int mid=(left+right)/2;

        int leftNum=reversePairs(nums,temp,left,mid);
        int rightNum=reversePairs(nums,temp,mid+1,right);
        if(nums[mid]<=nums[mid+1])return leftNum+rightNum;
        int crossNum=merge(nums,temp,left,right);
        return leftNum+rightNum+crossNum;
    }

    public  static int merge(int[] nums,int[] temp,int left,int right){
        for(int i=left;i<=right;i++){
            temp[i]=nums[i];
        }

        int mid=(left+right)/2;
        int smallP=left;
        int bigP=mid+1;
        int count=0;

        for(int k=left;k<=right;k++){
            if(smallP==mid+1){
                nums[k]=temp[bigP++];
            }else if(bigP==right+1){
                nums[k]=temp[smallP++];
            }else if(nums[smallP]<=nums[bigP]){
                nums[k]=temp[smallP++];
            }else{
                nums[k]=temp[bigP++];
                count+=(mid-smallP+1);
            }
        }
        return count;

    }
}
