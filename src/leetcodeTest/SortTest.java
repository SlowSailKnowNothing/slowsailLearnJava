package leetcodeTest;

import java.util.Random;

public class SortTest {
    static Random random=new Random();
    public static void main(String[] args) {

    }

    public static void quickSort(int[] array){
        int left=0;
        int len=array.length;
        int right=len-1;
        quickSort(array,left,right);
    }

    public static void quickSort(int[] array,int start,int end){
        if(start>=end)return;
        int index=partition(array,start,end);
        quickSort(array,start,index-1);
        quickSort(array,index+1,end);
    }

    public static int partition(int[] array, int start, int end){
       int index= random.nextInt(end - start+1)+start;
       swap(array,index,0);
       int left=start+1; //  [start,left)  <=pivot
       int right=end;//(right,end]>=pivot
       int pivot=array[0];
       while(left<=right){
           while(left<=right&&array[left]<=pivot){
               left++;
           }

           while(left<=right&&array[right]>=pivot){
               right--;
           }

           if(left<=right)swap(array,left,right);
           left++;
           right--;
       }
       swap(array,start,right);
       return right;
    }

    public static void swap(int[] array, int start, int end){
        int temp=array[start];
        array[start] = array[end];
        array[end]=temp;
    }

}
