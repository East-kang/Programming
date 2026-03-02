import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int value;
		List<Integer> children = new ArrayList<>();
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	static Node[] nodes;
    static boolean[] visited;
    static int N, M, cntEdges, cntNodes;
    
    public static void main(String[] args) throws Exception {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		int T = Integer.parseInt(br.readLine());
    		for(int t=1; t<=T; t++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			N = Integer.parseInt(st.nextToken());
    			M = Integer.parseInt(st.nextToken());
    			nodes = new Node[N+1];
    			for(int i=1; i<=N; i++) {
    				nodes[i] = new Node(i);
    			}
    			
    			for(int i=0; i<M; i++) {
    				st = new StringTokenizer(br.readLine());
    				int start = Integer.parseInt(st.nextToken());
    				int end = Integer.parseInt(st.nextToken());
    				nodes[start].children.add(end);
    				nodes[end].children.add(start);
    			}
    			
    			cntEdges = cntNodes = 0;
    			visited = new boolean[N+1];
    			recursive(1);
				
    			System.out.println(cntEdges);
    		}
    }

    private static void recursive(int node) {
		if(cntNodes == M)
			return;
    		visited[node] = true;
    		cntNodes++;
    		for(int next : nodes[node].children)
    			if(!visited[next]) {
    	    			cntEdges++;
    				recursive(next);
    			}
    }
}