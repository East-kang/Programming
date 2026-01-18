import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) B[j] = Integer.parseInt(st.nextToken());

            int ans = Integer.MIN_VALUE;

            if (N <= M) {
                for (int shift = 0; shift <= M - N; shift++) {
                    int sum = 0;
                    for (int i = 0; i < N; i++) sum += A[i] * B[i + shift];
                    ans = Math.max(ans, sum);
                }
            } else {
                for (int shift = 0; shift <= N - M; shift++) {
                    int sum = 0;
                    for (int j = 0; j < M; j++) sum += B[j] * A[j + shift];
                    ans = Math.max(ans, sum);
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.print(sb.toString());
    }
}
