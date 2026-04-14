import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			boolean map[][] = new boolean[N+1][N+1];
			int result = 0;
			for(int m=0; m<M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = true;
			}
			
			for(int k=1; k<=N; k++) {
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=N; j++) {
						map[i][j] = map[i][j] || (map[i][k] && map[k][j]);
					}
				}
			}
			
			for(int i=1; i<=N; i++) {
				boolean isOk = true;
				for(int j=1; j<=N; j++) {
					if(i==j) continue;
					isOk = isOk && (map[i][j] || map[j][i]);
				}
				if(isOk)
					result++;
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}