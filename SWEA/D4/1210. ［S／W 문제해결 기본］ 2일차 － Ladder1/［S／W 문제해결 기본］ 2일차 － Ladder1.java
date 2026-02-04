import java.io.*;
import java.util.*;

public class Solution {
	static Queue<int[]> q;
	static int[] dr = {0,0,-1};
	static int[] dc = {-1,1,0};
	static int result = -1;
	static int size = 100;
	static boolean[][] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			int T = Integer.parseInt(br.readLine());
			int[][] map = new int[size][size];
			int er = -1;
			int ec = -1;
			q = new ArrayDeque<>();
			v = new boolean[size][size];
			for(int r=0; r<size; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<size; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] == 2) {
						q.offer(new int[] {r,c});
						v[r][c] = true;
					}
				}
			}
			
			dfs(map);
			System.out.println("#" + T + " " + result);
		}
	}
	
	public static void dfs(int[][] map) {
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int cr = p[0];
			int cc = p[1];
			
			for(int i=0; i<3; i++) {
				int nr = cr+dr[i];
				int nc = cc+dc[i];
				
				if(nr<0 || nc<0 || nr>=size || nc>=size || map[nr][nc] != 1 || v[nr][nc]) continue;
				if(nr == 0) {
					result = nc;
				} else {
					q.offer(new int[] {nr, nc});
					v[nr][nc] = true;
					break;
				}
			}
		}	
	}
}
