import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int value;
		List<Integer> next = new ArrayList<>();
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	static Node nodes[];
	
    public static void main(String[] args) throws Exception {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(st.nextToken());
    		int M = Integer.parseInt(st.nextToken());
    		
    		nodes = new Node[N+1];
    		for(int i=1; i<=N; i++) {
    			nodes[i] = new Node(i);
    		}
    		
    		int[] phase = new int[N+1];
    		for(int i=0; i<M; i++) {
    			st = new StringTokenizer(br.readLine());
        		int front = Integer.parseInt(st.nextToken());
        		int back = Integer.parseInt(st.nextToken());
        		nodes[front].next.add(back);
        		nodes[back].next.add(front);
        		phase[front]++;
    		}
    		
    		Queue<Integer> q = new ArrayDeque<>();
    		Stack<Integer> s = new Stack<>();
    		boolean visited[] = new boolean[N+1];
    		for(int i=1; i<=N; i++) {
    			if(phase[i] == 0) {
    				q.offer(i);
    				visited[i] = true;
    			}
    		}
    		
    		while(!q.isEmpty()) {
    			int num = q.poll();
    			s.push(num);
    			for(int next: nodes[num].next) {
    				if(visited[next]) continue;
    				if(--phase[next] == 0) {
    					q.offer(next);
    					visited[next] = true;
    				}
    			}
    		}
    		while(!s.isEmpty()) {
    			System.out.print(s.pop() + " ");
    		}
    }
}