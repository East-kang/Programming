import java.io.*;
import java.util.*;

public class Solution {
	static boolean[] visited;
	static int maxTime, maxVertex;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] list = new ArrayList[101];
			for(int i=1; i<=100; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<len/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				list[from].add(to);
			}
			visited = new boolean[101];
			bfs(list, start);
			
			System.out.println("#" + t + " " + maxVertex);
		}
	}

	private static void bfs(ArrayList<Integer>[] list, int start) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start, 0});
		visited[start] = true;
		
		maxTime = 0;
		maxVertex = start;
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int vertex = point[0];
			int time = point[1];
			
			if(maxTime < time) {
				maxTime = time;
				maxVertex = 0;
			}
			maxVertex = Math.max(maxVertex, vertex);
			
			for(int v : list[vertex]) {
				if(visited[v])	continue;

				q.offer(new int[] {v, time+1});
				visited[v] = true;
			}
		}	
	}
    
}