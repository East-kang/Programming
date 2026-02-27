import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {1, -1, 0 ,0};
	static int[] dx = {0, 0, 1 ,-1};
	
	public static void bfs(int[][] map) {
		Deque<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[map.length][map[0].length];
		
		q.offer(new int[]{0, 0});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int y = point[0];
			int x = point[1];
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(ny<0 || ny>=map.length || nx<0 || nx>=map[0].length || map[ny][nx]==0 || visited[ny][nx]) continue;
				q.offer(new int[] {ny, nx});
				map[ny][nx] += map[y][x];
				visited[ny][nx] = true;
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(map);
		bw.write(Integer.toString(map[N-1][M-1]));
		bw.close();
	}
}