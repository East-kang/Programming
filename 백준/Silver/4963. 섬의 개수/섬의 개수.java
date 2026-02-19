import java.io.*;
import java.util.*;

public class Main {
	static int w, h, map[][], cnt;
	static boolean vis[][];
	static int[] dx = {1,1,1,0,0,-1,-1,-1};
	static int[] dy = {0,1,-1,1,-1,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			cnt = 0;
			
			if(w==0 && h==0) break;
			map = new int[h][w];
			vis = new boolean[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j]==1 && !vis[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	private static boolean isOut(int y, int x) {
		return (x<0 || y<0 || x>=w || y>=h);
	}
	
	private static void dfs(int y, int x) {
		if(isOut(y, x)) return;
		if(vis[y][x] || map[y][x]==0) return;
		
		vis[y][x] = true;
		for(int i=0; i<8; i++)
			dfs(y+dy[i], x+dx[i]);	
	}
}