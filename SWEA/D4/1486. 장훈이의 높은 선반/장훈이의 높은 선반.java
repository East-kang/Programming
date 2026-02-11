import java.io.*;
import java.util.*;

public class Solution {

	static int min;
	static int N, B, height[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			height = new int[N];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}
	
	private static void permutation(int idx, int sum) {
		if(sum >= B)
			min = Math.min(min, sum-B);
		
		if(idx == N)
			return;
		
		// 안넣는 경우
		permutation(idx+1, sum);
		// 넣는 경우
		permutation(idx+1, sum+height[idx]);
	}
}