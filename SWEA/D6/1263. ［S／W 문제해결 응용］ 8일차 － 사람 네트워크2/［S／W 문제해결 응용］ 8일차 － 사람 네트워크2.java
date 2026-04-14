import java.io.*;
import java.util.*;
public class Solution {
	static int INF = 10000;
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
			int result = INF;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int x = Integer.parseInt(st.nextToken());
					map[i][j] = (x==0? (i==j? 0: INF) : x);
				}
			}
			
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dist[i] += map[i][j];
				}
				result = Math.min(result, dist[i]);
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}