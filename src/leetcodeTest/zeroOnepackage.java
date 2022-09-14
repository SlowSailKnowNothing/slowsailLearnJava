package leetcodeTest;

public class zeroOnepackage {
    public static void main(String[] args) {

    }

    public static int compute(int[] weight,int[] value,int capacity){
        // weight是消耗的空间
        //capcity是总容量
        //value是每个物品的值

        //dp[i][j]:在选择第i个节点，空间还有j的时候，说可能获得的最大价值

        //dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-capacity]+weight[i]
        /*
        上面的dp式子怎么看都不舒服，不知道可不可以改变一下，把i-1改成i+1
        考虑到这里dp[i][j]表示的是获得最大价值，那么i-1改成i+1就值得商榷了。
         */


        return 0;
    }
}
