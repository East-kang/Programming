import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> map = new HashMap<>();
		long key = Long.MAX_VALUE;
		long maxValue = 0;
		for(int i=0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			if(!map.containsKey(num))
				map.put(num, 1);
			else
				map.put(num, map.getOrDefault(num, 0) + 1);
			long cur = map.get(num);
			if(maxValue < cur) {
				maxValue = cur;
				key = num;
			} else if(maxValue == cur) {
				key = Math.min(key, num);
			}
		}
		
		System.out.println(key);
	}
}