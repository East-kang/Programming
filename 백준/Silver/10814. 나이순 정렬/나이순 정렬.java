import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		List<Object[]>[] list = new ArrayList[201];
		for(int i=1; i<=200; i++) {
			list[i] = new ArrayList<>();
		}
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			list[age].add(new Object[] {age, name});
		}
		
		for(int i=1; i<201; i++) {
			if(list.length != 0) {
				for(Object[] o : list[i])
					sb.append(o[0]).append(" ").append(o[1]).append("\n");
			}
		}
		System.out.println(sb);
	}
}