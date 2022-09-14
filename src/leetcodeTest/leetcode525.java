package leetcodeTest;

public class leetcode525 {
    public static void main(String[] args) {
        int[] nums={0,1,0,0,1,0,1,0};
        int[] preT=new int[nums.length];

        int tot=0;
        for (int i=0; i<preT.length; i++){

            if(nums[i]==0){
                tot=tot-1;
            }else{
                tot=tot+1;
            }
            preT[i]=tot;
        }

        for(int num:preT){
            System.out.println(num);
        }
    }
}
