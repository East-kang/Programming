import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] a = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) a[i][j] = Integer.parseInt(st.nextToken());
            }

            sb.append("#").append(tc).append("\n");

            for (int i = 0; i < N; i++) {
                StringBuilder r90 = new StringBuilder();
                StringBuilder r180 = new StringBuilder();
                StringBuilder r270 = new StringBuilder();

                for (int j = 0; j < N; j++) r90.append(a[N - 1 - j][i]);
                for (int j = 0; j < N; j++) r180.append(a[N - 1 - i][N - 1 - j]);
                for (int j = 0; j < N; j++) r270.append(a[j][N - 1 - i]);

                sb.append(r90).append(" ").append(r180).append(" ").append(r270).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
