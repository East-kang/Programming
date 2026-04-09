import java.io.*;
import java.util.*;
public class Main {
	static class DP {
		int cnt;
		List<Integer> list;
		
		public DP(int cnt, List<Integer> list) {
			this.cnt = cnt;
			this.list = list;
		}
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		DP[] dp = new DP[x+1];
		for(int i=1; i<=x; i++) {
			dp[i] = new DP(0, new ArrayList<>() );
			dp[i].list.add(i);
			}
		
		for(int i=2; i<=x; i++) {
			dp[i].cnt = dp[i-1].cnt + 1;
			dp[i].list.clear();
			dp[i].list.add(i);
			dp[i].list.addAll(dp[i-1].list);
			
			if(i % 2 == 0) {
				if(dp[i].cnt > dp[i/2].cnt + 1) {
					dp[i].cnt = dp[i/2].cnt + 1;
					dp[i].list.clear();
					dp[i].list.add(i);
					dp[i].list.addAll(dp[i/2].list);
				}
			}
			if(i % 3 == 0) {
				if(dp[i].cnt > dp[i/3].cnt + 1) {
					dp[i].cnt = dp[i/3].cnt + 1;
					dp[i].list.clear();
					dp[i].list.add(i);
					dp[i].list.addAll(dp[i/3].list);
				}
			}
		}
		System.out.println(dp[x].cnt);
		for(Integer a : dp[x].list)
			System.out.print(a + " ");
	}
}