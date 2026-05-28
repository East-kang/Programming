import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        long map[][] = new long[n+1][m+1];
        
        map[1][1] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                boolean isPuddle = false;
                
                for(int[] puddle : puddles) {
                    if(i == puddle[1] && j == puddle[0]) {
                        isPuddle = true;
                        break;
                    }
                }
                if(isPuddle) continue;
                long left = map[i][j-1];
                long up = map[i-1][j];
                map[i][j] += (left + up) % 1000000007;
            }
        }
        
        return (int)map[n][m];
    }
}