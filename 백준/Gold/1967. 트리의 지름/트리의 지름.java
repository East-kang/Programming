import java.io.*;
import java.util.*;
public class Main {

	static class Node {
		int n, sum, weight;
		List<Node> children = new ArrayList<>();
		public Node(int n, int sum, int weight) {
			this.n = n;
			this.sum = sum;
			this.weight = weight;
		}
	}
	
	static Node[] nodes;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		nodes = new Node[n+1];
		result = -1;
		for(int i=0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if(nodes[parent] == null)
				nodes[parent] = new Node(parent, 0, 0);
			if(nodes[child] == null)
				nodes[child] = new Node(child, 0, weight);
			else
				nodes[child].weight = weight;
			nodes[parent].children.add(nodes[child]);
		}
		if(n == 1) result = 0;
		else dfs(1);
		
		System.out.println(result);
	}
	
	private static int dfs(int n) {
		if(nodes[n].children.size() == 0) {
			return nodes[n].weight;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for(Node node : nodes[n].children) {
			int weight = dfs(node.n);
			pq.offer(weight);
		}
		int first = pq.poll();
		int second = pq.isEmpty()? 0 : pq.poll();
		result = Math.max(result, first+second);
		nodes[n].sum = first+second;
		nodes[n].weight += first;
		return nodes[n].weight;
	}
}