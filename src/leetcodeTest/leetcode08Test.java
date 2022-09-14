package leetcodeTest;

public class leetcode08Test {
    public static void main(String[] args) {
        int ans=myAtoi("2147483648");
        System.out.println(ans);
    }
    public static int myAtoi(String s) {
        /*
        1.前置空格，跳过。
        2.遇到数字，判断数字
        3.遇到奇怪字符，停止。
        4.判断溢出。
         */

        boolean startCount=false;
        char[] charArray=s.toCharArray();
        int num=0;
        boolean isPositive=true;
        for(int i=0;i<charArray.length;i++){
            if(startCount&&!isDigit(charArray[i]))break;
            if(!startCount&&charArray[i]==' ')continue;
            if(charArray[i]=='-'){
                isPositive = false;
                startCount=true;
                continue;
            }
            if(charArray[i]!=' '&&!isDigit(charArray[i]))break;
            if(isDigit(charArray[i])){
                if(isOutOfRange(num,charArray[i],isPositive)){
                    return isPositive==true?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                num=num*10-(charArray[i]-'0');
            }
            startCount=true;
        }

        return isPositive==false?num:-num;//每次计算的都是负数
    }

    public static boolean isOutOfRange(int num,char ch,boolean isPositive){
        if(isPositive){
            if(-num>(Integer.MAX_VALUE-ch+'0')/10||(-num==(Integer.MAX_VALUE-ch+'0')/10)&&(-num*10>Integer.MAX_VALUE-ch+'0')){
                return true;
            }else return false;
        }

        if(num<(Integer.MIN_VALUE+ch-'0')/10||(num==(Integer.MIN_VALUE+ch-'0')/10)&&(num*10<Integer.MIN_VALUE+ch-'0'))
            return true;
        return false;
    }

    public static boolean isDigit(char ch){
        if(ch>='0'&&ch<='9')return true;
        else return false;
    }
}
