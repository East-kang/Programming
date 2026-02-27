import java.io.*;
import java.util.*;

/*
 * 완전 탐색: 전체 칸에 1을 배치할 수 있는 경우 전부 계산.
 * BFS: 퍼지는 바이러스 영역 구해 안전 구역 계산.
 */
public class Main {
    static int N, M;
    static int[][] map;
    static List<int[]> virus_list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 2) virus_list.add(new int[]{y, x});
            }
        }

        // 첫 벽을 메인에서 하나씩 찍고 들어가기
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 0) {
                    map[y][x] = 4;
                    full_search(map, y, x, 1);
                    map[y][x] = 0;
                }
            }
        }

        System.out.println(max);
	}
	
	// add_wall: 지금까지 세운 벽 개수
    private static void full_search(int[][] map, int y, int x, int add_wall) {
        if (add_wall == 3) {
            max = Math.max(max, spread_virus(map, virus_list));
            return; // 중요
        }

        int base = x + y * M;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cur = j + i * M;
                if (cur <= base) continue;

                if (map[i][j] == 0) {
                    map[i][j] = 4; // 벽
                    full_search(map, i, j, add_wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
	
    private static int spread_virus(int[][] map, List<int[]> points) {
        // 빈 칸(0)만 세기
        int empty = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 0) empty++;

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        // 시작 바이러스들 enqueue
        for (int[] p : points) {
            q.offer(new int[]{p[0], p[1]});
            visited[p[0]][p[1]] = true;
        }

        // 감염된 빈칸 수
        int infected = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0], cx = cur[1];

            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];

                // 경계 체크: ny는 N, nx는 M
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (visited[ny][nx]) continue;

                // 빈칸(0)으로만 전파 가능
                if (map[ny][nx] != 0) continue;

                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
                infected++;
            }
        }

        return empty - infected;
    }
}