import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String text = br.readLine();
		String pattern = br.readLine();
		int[] pi = new int[pattern.length()];
		int cnt=0;

		// 1) pi 생성
		int j = 0;
		for(int i=1; i<pattern.length(); i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		j = 0;
		for(int i=0; i<text.length(); i++) {
			while(j > 0 && text.charAt(i) != pattern.charAt(j)){
				j = pi[j-1];
			}
			
			if(text.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length()-1) {
					cnt++;
					sb.append(i-j+1).append(" ");
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	}
}