package leetcodeTreeTest;

import java.util.Arrays;

public class competenceTest {
    public static void main(String[] args) {
        String[] nums={"52","1","59","57174","5887"};
        Arrays.sort(nums,(s1,s2)->{
            if(s1.length()<s2.length())return 1;
            else if(s1.length()>s2.length())return -1;
            else{
                for(int i=0;i<s1.length();i++){
                    if(s1.charAt(i)<s2.charAt(i))return 1;
                    else if(s1.charAt(i)>s2.charAt(i))return -1;
                }
                return 0;
            }
        });
        for(String num:nums){
            System.out.println(num);
        }
        System.out.println(nums[3]);

    }
}
