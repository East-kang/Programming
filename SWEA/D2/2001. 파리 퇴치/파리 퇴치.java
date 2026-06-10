import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
        for(int tc=1; tc<=T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int map[][] = new int[n][n];

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = 0;
            for(int i=0; i<=n-m; i++) {
                for(int j=0; j<=n-m; j++) {
                    int sum = 0;
                    for(int k=i; k<i+m; k++) {
                        for(int l=j; l<j+m; l++) {
                            sum += map[k][l];
                        }
                    }
                    ans = Math.max(ans, sum);
                }
            }
            sb.append(ans).append("\n");
		}
        System.out.println(sb.toString());
	}
}