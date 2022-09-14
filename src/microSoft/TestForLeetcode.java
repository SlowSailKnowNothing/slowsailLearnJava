package microSoft;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestForLeetcode {
    public static void main(String[] args) {

    }

    public String reverseParentheses(String s) {
        Deque<Integer> stack=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder(s);

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i)==')'){
                int index=stack.pop();
                reverse(sb,index,i-1);//反转从index到i-1的元素
            }else continue;
        }

        return sb.toString().trim().trim();
    }


    public void reverse(StringBuilder sb,int index1,int index2){
        while(index1<index2){
            char ch=sb.charAt(index1);

        }
    }
}
