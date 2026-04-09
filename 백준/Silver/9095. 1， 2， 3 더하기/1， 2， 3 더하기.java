import java.io.*;
import java.util.*;
public class Main {

	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[11];
		dp[1] = 1;	dp[2] = 2;	dp[3] = 4;
		for(int i=4; i<=10; i++)
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		
		for(int t=0; t<T; t++)
			System.out.println(dp[Integer.parseInt(br.readLine())]);
	}
}