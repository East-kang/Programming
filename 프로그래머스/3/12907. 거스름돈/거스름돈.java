import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int m : money) {
            for(int i=m; i<n+1; i++) {
                dp[i] += dp[i-m];
            }
        }
        
        return dp[n] % 1000000007;
    }
    
    private static void func(int n, int[] money) {
        
    }
}