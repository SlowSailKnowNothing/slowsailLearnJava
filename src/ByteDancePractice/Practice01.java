package ByteDancePractice;

import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt(); //只会读取数值，不会读取换行符号
        scanner.nextLine();
        for(int i=0;i<n;i++){
            String str=scanner.nextLine();
            System.out.println(modify(str));
        }
    }

    public static String modify(String str){
        char[] charArray=str.toCharArray();
        StringBuilder sb=new StringBuilder();
        int repeatPoint1=1;
        while(repeatPoint1<charArray.length){
            if(charArray[repeatPoint1-1]!=charArray[repeatPoint1]){

            }else{
                int repeatPoint2=repeatPoint1+1;
                if(repeatPoint2<charArray.length){
                    if(charArray[repeatPoint2]==charArray[repeatPoint1]){
                        //连续出现3个相同
                        charArray[repeatPoint2]='0';
                    }else if(repeatPoint2<charArray.length-1&&charArray[repeatPoint2]==charArray[repeatPoint2+1]){
                        //出现AABB
                        charArray[repeatPoint2]='0';
                    }
                }
            }
            repeatPoint1++;
        }

        for(char ch:charArray){
            if(ch!='0'){
                sb.append(ch);
            }
        }
        return sb.toString();


    }
}
