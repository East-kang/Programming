import java.io.*;
import java.util.*;
public class Solution {

	static int N, M, map[][], cost[], total[], result, house, count;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] vis;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			cost = new int[2*N+1];
			total = new int[2*N+1];
			result = M-1 >= 0 ? 1 : 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
	
			for(int i=1; i<=2*N; i++)
				cost[i] = i*i + (i-1)*(i-1);
			
			for(int k=2; k<=2*N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						count = 0;
						for(int y=0; y<N; y++) {
							for(int x=0; x<N; x++) {
								if(Math.abs(i-y) + Math.abs(j-x) >= k) continue;
								if(map[y][x] == 1) count++;
							}
						}
						if(count*M - cost[k] >= 0)
							result = Math.max(result, count);
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}