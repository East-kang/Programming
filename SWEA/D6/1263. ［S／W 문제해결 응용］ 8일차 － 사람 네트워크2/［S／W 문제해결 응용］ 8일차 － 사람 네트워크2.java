import java.io.*;
import java.util.*;
public class Solution {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int[] dist = new int[N];
			int result = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int x = Integer.parseInt(st.nextToken());
					map[i][j] = (x==0? (i==j? 0: 1000) : x);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i == j) continue;
					if(map[i][j] == 1000) {
						for(int k=0; k<N; k++) {
							if(k == i || k == j) continue;
							map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
						}
					}
					dist[i] += map[i][j]; 
				}
				result = Math.min(result, dist[i]);
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}