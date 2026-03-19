import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			long num = Long.parseLong(st.nextToken());
			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			} else {
				map.put(num, 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			long num = Long.parseLong(st.nextToken());
			bw.write(Integer.toString(map.getOrDefault(num, 0)));
			if(i<M-1)
				bw.write(" ");
		}
		bw.close();
	}
}