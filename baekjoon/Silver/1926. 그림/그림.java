import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	public static int bfs(int[][] map, int y, int x) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{y,x});
		map[y][x] = 0;
		int dimention = 1;
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			
			for(int i=0; i<4; i++) {
				int ny = point[0]+dy[i];
				int nx = point[1]+dx[i];
				
				if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && map[ny][nx] == 1) {
					map[ny][nx] = 0;
					q.offer(new int[]{ny, nx});
					dimention++;
				}
			}
		}
		
		return dimention;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		int max = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1) {
					max = Math.max(max, bfs(map, i, j));
					count++;
				}
			}
		}
		
		bw.write(count + "\n" + max);
		bw.close();
	}
}
