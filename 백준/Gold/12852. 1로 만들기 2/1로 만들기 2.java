import java.util.*;
public class Main {
	static class DP {
		int cnt;
		List<Integer> list;
		
		public DP(int idx) {
			this.cnt = 0;
			this.list = new ArrayList<>();
			list.add(idx);
		}
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] dp = new int[x+1];
		int[] prev = new int[x+1];
		
		for(int i=2; i<=x; i++) {
			dp[i] = dp[i-1] + 1;
			prev[i] = i-1;
			
			if(i % 2 == 0) {
				if(dp[i] > dp[i/2] + 1) {
					dp[i] = dp[i/2] + 1;
					prev[i] = i/2;
				}
			}
			if(i % 3 == 0) {
				if(dp[i] > dp[i/3] + 1) {
					dp[i] = dp[i/3] + 1;
					prev[i] = i/3;
				}
			}
		}
		System.out.println(dp[x]);
		for(int i=x; i>=1; i = prev[i])
			System.out.print(i + " ");
	}
}