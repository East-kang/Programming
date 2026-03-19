import java.io.*;
public class Main {

	static int bucket[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bucket = new int[10001];
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			bucket[num]++;
		}
		
		for(int i=1; i<=10000; i++) {
			for(int j=0; j<bucket[i]; j++)
				bw.write(i + "\n");
		}
		bw.close();
	}
}