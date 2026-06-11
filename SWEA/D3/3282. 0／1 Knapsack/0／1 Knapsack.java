import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int v[] = new int[n+1];
            int c[] = new int[n+1];
            for(int i=1; i<=n; i++) {
                st = new StringTokenizer(br.readLine());
                v[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }

            int dp[][] = new int[n+1][k+1];
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=k; j++){
                    if(v[i] > j) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], c[i] + dp[i-1][j-v[i]]);
                    }
                }
            }

            sb.append(dp[n][k]).append("\n");
        }
        System.out.println(sb.toString());
    }
}