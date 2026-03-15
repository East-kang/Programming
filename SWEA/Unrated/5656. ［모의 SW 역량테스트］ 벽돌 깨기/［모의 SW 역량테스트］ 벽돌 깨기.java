import java.io.*;
import java.util.*;

public class Solution {

	static int N, W, H, map[][], result;
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
			map = new int[H][W];
			result = Integer.MAX_VALUE;
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, map);
			System.out.println("#" + t + " " + result);
		}
	}
	
	private static void dfs(int cnt, int[][] map) {
		if(cnt == N) {
			result = Math.min(result, countBlocks(map));
			return;
		}
		
		for(int i=0; i<W; i++) {
			int[][] tmp = new int[H][W];
			for(int j=0; j<H; j++) {
				tmp[j] = map[j].clone();
			}
			dfs(cnt+1, setGravity(bomb(i, tmp)));
		}
	}

	private static int[][] setGravity(int[][] map) {
		Deque<Integer> q = new ArrayDeque<>();
		for(int j=0; j<W; j++) {
			int ey = -1;
			boolean gravity = false;
			for(int i=H-1; i>=0; i--) {
				if(!gravity && map[i][j]==0) {
					ey = i;	gravity = true;
					continue;
				}
				if(gravity && map[i][j]>0) {
					q.offer(map[i][j]);
					map[i][j] = 0;
				}
			}
			while(!q.isEmpty()) {
				map[ey--][j] = q.poll();
			}
		}
		return map;
	}

	private static int[][] bomb(int x, int[][] map) {
		Deque<int[]> q = new ArrayDeque<>();
		boolean vis[][] = new boolean[H][W];
		int y = 0;
		for(int i=0; i<H; i++) {
			if(map[i][x] > 0) { y = i; break; }
		}
		
		q.offer(new int[] {y, x});
		vis[y][x] = true;
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int cy = pos[0];		int cx = pos[1];
			int range = map[cy][cx];
			map[cy][cx] = 0;
			for(int i=0; i<4; i++) {
				for(int j=1; j<range; j++) {
					int ny = cy + dy[i] * j;
					int nx = cx + dx[i] * j;
					if(ny<0 || nx<0 || ny>=H || nx>=W || vis[ny][nx] || map[ny][nx]==0) continue;
					q.offer(new int[] {ny, nx});
					vis[ny][nx] = true;
				}
			}
		}
		return map;
	}

	private static int countBlocks(int[][] map) {
		int cnt = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] > 0)
					cnt++;
			}
		}
		return cnt;
	}
}
