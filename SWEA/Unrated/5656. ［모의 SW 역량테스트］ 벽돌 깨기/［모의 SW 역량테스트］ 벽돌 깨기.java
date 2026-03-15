import java.io.*;
import java.util.*;

public class Solution {
	static int N, H, W, grid[][], result;
	static int dy[] = {1, 0, -1, 0};
	static int dx[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			grid = new int[H][W];
			result = Integer.MAX_VALUE;
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, grid);
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	private static void dfs(int cnt, int[][] map) {
		if(cnt == N)	 {
			result = Math.min(result, countBlocks(map));
			return;
		}
		
		for(int i=0; i<W; i++) {
			int temp[][] = new int[H][W];
			for(int j=0; j<H; j++) {
				temp[j] = map[j].clone();
			}
			dfs(cnt+1, setGravity(bomb(i, temp)));
		}
	}
	
	private static int[][] bomb(int x, int[][] map) {
		Deque<int[]> q = new ArrayDeque<>();
		boolean visited[][] = new boolean[H][W];
		for(int i=0; i<H; i++) {
			if(map[i][x] > 0) {
				q.offer(new int[] {i, x});
				visited[i][x] = true;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int pos[] = q.poll();
			int cy = pos[0];
			int cx = pos[1];
			int range = map[cy][cx]-1;
			map[cy][cx] = 0;
			
			for(int i=0; i<4; i++) {
				for(int j=1; j<=range; j++) {
					int ny = cy + dy[i] * j;
					int nx = cx + dx[i] * j;
					if(ny<0 || nx<0 || ny>=H || nx>=W || visited[ny][nx] || map[ny][nx]==0) continue;
					q.offer(new int[] {ny, nx});
					visited[ny][nx] = true;
				}
			}
		}
		return map;
	}
	
	private static int[][] setGravity(int[][] map) {
		Deque<Integer> q = new ArrayDeque<>();
		for(int i=0; i<W; i++) {
			int ey = H-1;
			boolean gravity = false;
			for(int j=H-1; j>=0; j--) {
				if(!gravity && map[j][i]==0) {
					gravity = true;
					ey = j;
					continue;
				}
				if(gravity && map[j][i]>0) {
					q.offer(map[j][i]);
					map[j][i] = 0;
				}
			}
			while(!q.isEmpty()) {
				map[ey--][i] = q.poll();
			}
		}
		return map;
	}
	
	private static int countBlocks(int[][] map) {
		int count = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] > 0)
					count++;
			}
		}
		return count;
	}
}
