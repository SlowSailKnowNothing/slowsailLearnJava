public class TestByte {
    public static int byteToInteger(byte[] b,int start,int len){
        int res=0;
        int end=len+start;
        for(int i=start;i<end;i++){
            int cur=b[i];
            System.out.println(cur);
            cur<<=(--len)*8;
            res+=cur;
        }


        return res;
    }
    public static void main(String[] args) {
        byte a=12;
        int b=a;
        byte[] byteTest=new byte[]{0x0,0x0,0x01,0x01};
        int testRes=byteToInteger(byteTest,0,4);
        System.out.println(testRes);
    }
}
