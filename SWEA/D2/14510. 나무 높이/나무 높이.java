// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AYFofW8qpXYDFAR4

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] trees = new int[N];
			int max = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, trees[i]);
			}
			
			int one=0, two=0;
			
			for(int i=0; i<N; i++) {
				one += (max-trees[i]) % 2;
				two += (max-trees[i]) / 2;
			}
			
			int min = Math.min(one, two);
			one -= min;
			two -= min;
			
			int result = min*2;
			if(two==0)
				result += one*2-1;
			if(one==0)
				result += (two+1) + (two-1)/3;
			
			bw.write("#"+t+" "+result+"\n");
		}
		bw.close();
	}
}
