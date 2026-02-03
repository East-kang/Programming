import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			boolean[][] v = new boolean[N][N];
			boolean[][] v_mass = new boolean[N][N];
			int max_num = 0;
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					max_num = Math.max(max_num, map[r][c]);
				}
			}
			
			int max_count = 1;
			for(int d=1; d<=max_num; d++) {
				int count_mass = 0;
				
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						if(map[r][c] == d) {
							v[r][c] = true;
						}
					}
				}
				for(int i=0; i<N; i++)
					v_mass[i] = v[i].clone();
				
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						if(!v_mass[r][c]) {
							bfs(v_mass, r, c);
							count_mass++;
						}
					}
				}
				max_count = Math.max(max_count, count_mass);
			}
			for(int i=0; i<N; i++)
				v_mass[i] = v[i].clone();
			System.out.println("#"+t+" "+max_count);
		}
	}
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void bfs(boolean[][] v, int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y,x});
		v[y][x] = true;
		int N = v.length;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int cy = p[0];
			int cx = p[1];
			
			for(int i=0; i<4; i++) {
				int ny = cy+dy[i];
				int nx = cx+dx[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || v[ny][nx]) continue;
				q.offer(new int[] {ny, nx});
				v[ny][nx] = true;
			}
		}
	}

}
