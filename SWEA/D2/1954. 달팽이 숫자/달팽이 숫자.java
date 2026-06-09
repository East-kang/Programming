import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append("#").append(tc).append("\n");
            int N = Integer.parseInt(br.readLine());
            int map[][] = new int[N][N];
            int num=1, dir=0, r=0, c=0, len = N;
            while(num <= N*N) {
                if(dir == 0) {
                    for(int i=0; i<len; i++) {
                        map[c][r++] = num++;
                    }
                    dir++;  c++;
                    len--;  r--;
                } else if(dir == 1) {
                    for(int i=0; i<len; i++) {
                        map[c++][r] = num++;
                    }
                    dir++;  c--;  r--;
                } else if(dir == 2) {
                    for(int i=0; i<len; i++) {
                        map[c][r--] = num++;
                    }
                    dir++;  c--;
                    len--;  r++;
                } else {
                    for(int i=0; i<len; i++) {
                        map[c--][r] = num++;
                    }
                    dir=0;  c++;  r++;
                }
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}