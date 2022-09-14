package leetcodeTest;

import java.util.Arrays;

public class leetcodePracticeTest {
    static int[] memo;
    public static void main(String[] args) {

    }

    public static int numTrees(int n){
        memo=new int[n+1];
        Arrays.fill(memo,-1);
        memo[1]=1;
        return dp(n);
    }

    public static int dp(int n){
        if(memo[n]!=-1)return memo[n];
        int count=0;
        for(int i=1;i<=n;i++){
            count+=dp(i)*dp(n-i);
        }
        return count;
    }
}
