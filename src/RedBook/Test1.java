package RedBook;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            int len=sc.nextInt();
            long limit=sc.nextLong();
            Long[] array=new Long[len];
            for(int i=0;i<len;i++){
                array[i]=sc.nextLong();
            }

            Arrays.sort(array,(a,b)->{
                return (int) (b-a);
            });
            int ans=0;

           int comareIndex=Integer.MAX_VALUE;
            for(int i=0;i<len-1;i++){
                if(i>comareIndex)break;
                comareIndex=findIndex(array,i,i+1,len-1,limit);
                ans+=(i-comareIndex);
            }

            System.out.println(2*ans);

        }
    }

    private static int findIndex(Long[] array, int i, int left, int right, long limit) {
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(array[i]*array[mid]>=limit){
                left=mid;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
}
