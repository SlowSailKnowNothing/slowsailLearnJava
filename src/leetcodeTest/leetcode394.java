package leetcodeTest;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode394 {
    public static void main(String[] args) {
        String input="3[a]";
       String out= decodeString(input);
        System.out.println(out);
    }
    public static String decodeString(String s) {
        int len=s.length();
        Deque<String> stack=new ArrayDeque<>();

        for(int i=0;i<len;i++){
            if(isDigit(s.charAt(i))){
                int u=0;
                while(i<len&&isDigit(s.charAt(i))){
                    u=u*10+s.charAt(i)-'0';
                    i++;
                }
                i--;
                stack.push(String.valueOf(u));//遇到数字将数字入栈，此刻指针指向已经不是数字，不需要移动
            }else if(s.charAt(i)==']'){

                StringBuilder sb=new StringBuilder();
                while(!stack.isEmpty()&&stack.peek()!="\\["){
                    sb.insert(0,stack.pop());
                }
                System.out.println(sb);
                //stack.pop();//这里是弹出[
//                int num=Integer.parseInt(stack.pop());
//                System.out.println(num);
//                String sbt=sb.toString();
//                for(int j=0;j<num;j++){
//                    stack.push(sbt);
//                }

            }else{
                stack.push(String.valueOf(s.charAt(i)));
                System.out.println(s.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();

    }

    public static boolean isDigit(char ch){
        if(ch>='0'&&ch<='9')return true;
        return false;
    }
}
