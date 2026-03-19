import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int index[] = new int[26];
		Arrays.fill(index, -1);
		
		String str = br.readLine();
		int len = str.length();
		for(int i=0; i<len; i++) {
			if(index[str.charAt(i)-'a'] == -1)
				index[str.charAt(i)-'a'] = i;
		}
		
		for(int i=0; i<26; i++) {
			bw.write(Integer.toString(index[i]));
			if(i<25)
				bw.write(" ");
		}
		bw.close();
	}
}