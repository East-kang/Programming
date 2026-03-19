import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count[] = new int[26];
		String str = br.readLine();
		int len = str.length();
		for(int i=0; i<len; i++) {
			count[str.charAt(i)-'a']++;
		}
		
		for(int i=0; i<26; i++) {
			bw.write(Integer.toString(count[i]));
			if(i<25)
				bw.write(" ");
		}
		bw.close();
	}
}