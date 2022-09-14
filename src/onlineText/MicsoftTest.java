package onlineText;

import java.util.*;

public class MicsoftTest {
    public static void main(String[] args) {


    }

    public int[] singleNumbers(int[] nums) {
            int bitBucket=0;
            for(int num:nums){
                bitBucket^=num;
            }

            int div=1;
            while((div&bitBucket)==0){
                div<<=1;
            }
            int a=0;
            int b=0;
            for(int n:nums){
                if((div&n)==0){
                    a^=n;
                }else{
                    b^=n;
                }
            }
            return new int[]{a,b};
    }

   







}
