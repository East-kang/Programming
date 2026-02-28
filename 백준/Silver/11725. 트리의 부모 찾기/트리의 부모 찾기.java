import java.io.*;
import java.util.*;

/*
 * 1. 노드 클래스 구현
 * 	  class -> data, next;
 */
public class Main {
	static class Node {
		int value;
		List<Node> children = new ArrayList<>();
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	static Node nodes[];
	static int N, parent[];
	static boolean visited[];
    public static void main(String[] args) throws Exception {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		N = Integer.parseInt(br.readLine());
    		nodes = new Node[N+1];
    		parent = new int[N+1];
    		visited = new boolean[N+1];
    		
    		for(int i=1; i<=N; i++)
    			nodes[i] = new Node(i);
    		
    		for(int i=0; i<N-1; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			int num = Integer.parseInt(st.nextToken());
    			int next = Integer.parseInt(st.nextToken());
    			nodes[num].children.add(nodes[next]);
    			nodes[next].children.add(nodes[num]);
    		}
    		
    		dfs(nodes[1]);
    		
    		for(int i=2; i<=N; i++)
    			System.out.println(parent[i]);
    }
    
	private static void dfs(Node node) {
		visited[node.value] = true;
		
		for(Node nxt: nodes[node.value].children)
			if(!visited[nxt.value]) {
				visited[nxt.value] = true;
				parent[nxt.value] = node.value;
				dfs(nxt);
			}	
	}
}