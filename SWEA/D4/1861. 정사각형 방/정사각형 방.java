import java.io.*;
import java.util.*;

// 완전탐색 + BFS(사방탐색)
public class Solution {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int maxCnt;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N+1][N+1];
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int start = Integer.MAX_VALUE;
			maxCnt = Integer.MIN_VALUE;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					visited = new boolean[N+1][N+1];
					if(maxCnt < bfs(map, i, j)) {
						maxCnt = bfs(map, i, j);
						start = map[i][j];
					} else if(maxCnt == bfs(map, i, j)) {
						start = Math.min(start, map[i][j]);
					}
				}
			}
			
			System.out.println("#" + t + " " + start + " " + maxCnt);
		}
	}

	private static int bfs(int[][] map, int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y, x});
		visited[y][x] = true;
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int cy = point[0];
			int cx = point[1];
			
			for(int i=0; i<4; i++) {
				int ny = cy+dy[i];
				int nx = cx+dx[i];
				
				if(nx<1 || ny<1 || nx>=map[0].length || ny>=map.length || map[ny][nx]-map[cy][cx] != 1) continue;
				q.offer(new int[] {ny, nx});
				visited[ny][nx] = true;
				cnt++;
			}
		}
		
		return cnt;
	}
}