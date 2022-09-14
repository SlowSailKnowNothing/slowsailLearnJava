package microSoft;

public class TestForMain {
    public static void main(String[] args) {
        /*
            1."12345678"
         */


        String testStr=String.valueOf(Integer.MAX_VALUE-1);
        String testStr3=String.valueOf(0);
        System.out.println(Integer.MAX_VALUE);
        String testStr2=String.valueOf(Integer.MIN_VALUE+1);
        System.out.println(myParseInt(testStr));
        System.out.println(myParseInt(testStr2));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(testStr3);
    }


    public static int myParseInt(String str) {
        int num = 0;
        boolean isNegative = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i == 0 && ch == '-') isNegative = true;
            // Integer.MAX>(num*10+ch-'0')---> Integer.MAX-(ch-'0')/10>num  Integer.MIN-'0'+ch<(num*10)--->
            if (!isNegative) {//正
                if(num*10<Integer.MAX_VALUE-(ch-'0'))
                if ((Integer.MAX_VALUE - (ch - '0')) / 10 > num&&num*10+(ch-'0')>Integer.MAX_VALUE) return Integer.MAX_VALUE;
                num = num * 10 + ch - '0';
            } else {
                // num*10+'0'-ch
                if ((Integer.MIN_VALUE + ch - '0') / 10 < num&& (num * 10 + '0'-ch)>0) return Integer.MIN_VALUE;
                num = num * 10 + '0' - ch;
            }

        }
        return num;
    }
}

