import java.io.*;
import java.util.*;

public class Solution {
	static Queue<int[]> q = new ArrayDeque<>();
	static int max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		Map<Character, Boolean> dic;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			char[][] map = new char[R+1][C+1];
			for(int i=1; i<=R; i++) {
				String str = br.readLine();
				for(int j=1; j<=C; j++) {
					map[i][j] = str.charAt(j-1);
				}
			}
			
			dic = new HashMap<>();
			max = Integer.MIN_VALUE;
			for(char c='A'; c<='Z'; c++)
				dic.put(c, false);
		
			q.offer(new int[] {1,1});
			dic.put(map[1][1], true);
			
			System.out.println("#" + t + " " + dfs(map, dic, 1));
			
		}
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static int dfs(char[][] map, Map<Character, Boolean> dic, int count) {
		
		int[] p = q.poll();
		int cr = p[0];
		int cc = p[1];
		int c = count;

		for(int i=0; i<4; i++) {
			int nr = cr+dr[i];
			int nc = cc+dc[i];
			
			if(nr<1 || nr>map.length-1 || nc<1 || nc>map[0].length-1) continue;
			if(dic.get(map[nr][nc])) continue;
			
			q.offer(new int[] {nr, nc});
			dic.put(map[nr][nc], true);
			count = Math.max(count, dfs(map, dic, c+1));
			dic.put(map[nr][nc], false);
		}
		return count;
	}
	
}