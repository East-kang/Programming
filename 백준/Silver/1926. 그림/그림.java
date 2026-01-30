import java.io.*;
import java.util.*;

public class Main {
	public static int bfs(int[][] map, int y, int x, int dimentions) {
		if(x<0 || x>=map[0].length || y<0 || y>=map.length || map[y][x] == 0) {
			return dimentions;
		}
		
		map[y][x] = 0;
		dimentions += (bfs(map, y+1, x, dimentions)
				+ bfs(map, y-1, x, dimentions)
				+ bfs(map, y, x+1, dimentions)
				+ bfs(map, y, x-1, dimentions) + 1);
		return dimentions;
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
		int dimentions = 0;
		int max = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {		
				if(map[i][j] == 1) {
					max = Math.max(max, bfs(map, i, j, dimentions));
					count++;
					dimentions = 0;
				}
			}
		}
		bw.write(count + "\n" + max);
		bw.close();
	}
}
