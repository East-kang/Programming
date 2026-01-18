import java.io.*;
import java.util.*;

public class Solution {

    static int N, M;
    static int[][] arr;

    // + 형태 계산
    static int calcPlus(int r, int c) {
        int sum = arr[r][c]; // 중심
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int k = 1; k < M; k++) { // 거리 1 ~ M-1
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d] * k;
                int nc = c + dc[d] * k;
                if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                    sum += arr[nr][nc];
                }
            }
        }
        return sum;
    }

    // x 형태 계산
    static int calcX(int r, int c) {
        int sum = arr[r][c]; // 중심
        int[] dr = {-1, -1, 1, 1};
        int[] dc = {-1, 1, -1, 1};

        for (int k = 1; k < M; k++) { // 거리 1 ~ M-1
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d] * k;
                int nc = c + dc[d] * k;
                if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                    sum += arr[nr][nc];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ans = Math.max(ans, calcPlus(i, j));
                    ans = Math.max(ans, calcX(i, j));
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.print(sb.toString());
    }
}
