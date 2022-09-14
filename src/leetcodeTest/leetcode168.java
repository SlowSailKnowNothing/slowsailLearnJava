package leetcodeTest;

public class leetcode168 {
    public static void main(String[] args) {
        int columnNumber=701;
        StringBuilder sb=new StringBuilder();
        while(columnNumber>0){
            sb.append((char)((columnNumber-1)%26+'A'));
            columnNumber=columnNumber/26;
        }
        sb.reverse();
    }
}
