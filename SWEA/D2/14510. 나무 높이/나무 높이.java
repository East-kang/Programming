/*
1. 최대값 뽑기
2. one, two 구하기(one: 차이%2, two: 차이/2)
3. min 구하고, 결과에 min*2 더하기
4. one==0: (two+1) + (two-1)/3;
5. two==0: one*2-1;
 */
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			int trees[] = new int[n];
			int max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, trees[i]);
			}
			
			int one=0, two=0, result=0;
			for(int i=0; i<n; i++) {
				int height = max - trees[i];
				two += height/2;
				one += height%2;
			}
			
			int min=Math.min(one, two);
			one -= min;
			two -= min;
			result += min*2;
			
			if(two==0) result += one*2-1;
			if(one==0) result += (two+1) + (two-1)/3;
			
			System.out.println("#" + t + " " + result);
		}

	}

}
