import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int len = N.length();
		int card[] = new int[9];
		for(int i=0; i<len; i++) {
			int idx = N.charAt(i)-'0';
			card[(idx==6 || idx==9) ? 6 : idx]++;
		}
		card[6] = (card[6]+1)/2;
		int result = 0;
		for(int i=0; i<9; i++)
			result = Math.max(result, card[i]);
		System.out.println(result);
	}
}