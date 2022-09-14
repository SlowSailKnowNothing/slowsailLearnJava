package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class leetcode93Test {
    public static void main(String[] args) {
        String str="25525511135";
        List<String> list = restoreIpAddresses(str);
    }

    public static List<String> restoreIpAddresses(String s) {
        /*
        1.递归终结条件：
            已经分了四段且字符串已经到了结尾
        2.递归每次要做的事情，分别将1,2,3个字符作为当前的字符串。
        3.
        */
        List<String> res=new ArrayList<>();
        dfs(s,res,new StringBuilder(),0,0);
        return res;
    }

    public static void dfs(String s, List<String> res, StringBuilder sb, int depth, int index){
        if(index==s.length()&&depth==4){
            res.add(sb.deleteCharAt(sb.length()-1).toString());
        }
        for(int i=0;i<3&&index+i<s.length();i++){
            if(isvalid(s,index,i)){
                sb.append(s.substring(index,index+i+1)+'.');//左闭右开区间
                dfs(s,res,sb,depth+1,index+i+1);
                sb.delete(index,index+i+2);
            }else{
                continue;
            }
        }
    }

    public static boolean isvalid(String s,int index,int offSet){//要取到i+index
        if(s.charAt(index)=='0')return offSet==0?true:false;
        int num=0;
        for(int i=0;i<=offSet;i++){
            num=num*10+s.charAt(index+offSet)-'0';
        }
        if(num<=255)return true;
        else return false;
    }

}
