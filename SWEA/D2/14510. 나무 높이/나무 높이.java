/*
1. 최대값 뽑기
2. one, two 날짜수 뽑기
3. one, two 중 최솟값 뽑아서 각자 빼고 결과에 x2 해서 더하기
4. one==0: (two+1) + (two-1)/3
5. two==0: one*2-1
6. 결과에 다 더하기
*/
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			int trees[] = new int[n];
			int max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int i=0; i<n; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, trees[i]);
			}
			
			int one=0, two=0, result=0;
			for(int i=0; i<n; i++) {
				int heights = max - trees[i];
				two+=heights/2;
				one+=heights%2;
			}
			
			int min = Math.min(one, two);
			one -= min;
			two -= min;
			result += min*2;
			
			if(one==0)	result += (two+1)+(two-1)/3;
			if(two==0)	result += one*2-1;
			
			bw.write("#" + t + " " + result + "\n");
		}
		bw.close();
	}
}
