import java.io.*;
import java.util.*;
public class Main {

	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			cnt = 0;
			calculation(Integer.parseInt(br.readLine()));
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void calculation(int x) {
		if(x==0) { cnt++; return; }
		if(x>=1) calculation(x-1);
		if(x>=2) calculation(x-2);
		if(x>=3) calculation(x-3);
	}
}