import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {1, -1, 0 ,0};
	static int[] dx = {0, 0, 1 ,-1};
	/**
	 * 
	 * @param map	: 전체 맵
	 * @param y		: 썩은 토마토가 있는 좌표들의 y좌표 배열
	 * @param x		: 썩은 토마토가 있는 좌표들의 x좌표 배열
	 * @param idx	: 썩은 토마토 갯수
	 * @return		: count: 썩게된 토마토 갯수
	 * 				   max : 토마토가 썩는데 걸린 날짜
	 */
	public static int[] bfs(int[][] map, int[] y, int[] x, int idx) {
		Deque<int[]> q = new ArrayDeque<>();
		int count = 0;
		int max = Integer.MIN_VALUE;

		for(int i=0; i<idx; i++) {
			q.offer(new int[] {y[i],x[i],count});
		}
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int cy = point[0];
			int cx = point[1];
			int cc = point[2];
			
			for(int i=0; i<4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				
				if(nx<0 || nx>=map[0].length || ny<0 || ny>=map.length) continue;
				if(map[ny][nx] == 1) continue;
				if(map[ny][nx] == -1)continue;
				
				q.offer(new int[] {ny, nx, cc+1});
				map[ny][nx] = 1;
				count++;
			}
			max = Math.max(max, cc);
		}
		return new int[] {count, max};
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];
		int[] y = new int[M*N];
		int[] x = new int[M*N];
		int idx = 0;
		int count = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					y[idx] = i;
					x[idx++] = j;
					count++;
				} else if (map[i][j] == -1) {
					count++;
				}
					
			}
		}
		
		int[] result = bfs(map, y, x, idx);
		if(N*M == result[0]+count)
			bw.write(Integer.toString(result[1]));
		else
			bw.write("-1");
		bw.close();
	}
}
