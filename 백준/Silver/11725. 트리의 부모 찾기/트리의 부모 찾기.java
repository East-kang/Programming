import java.io.*;
import java.util.*;

/*
 * 1. 전부 인접 리스트로 연결.
 * 2. 1부터 dfs 돌면서 노드 배열에 부모 저장 후 출력
 */
public class Main {
	static int N, parent[];
	static List<Integer> list[];
	static boolean visited[];
    public static void main(String[] args) throws Exception {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		N = Integer.parseInt(br.readLine());
    		list = new ArrayList[N+1];
    		parent = new int[N+1];
    		for(int i=1; i<=N; i++)
    			list[i] = new ArrayList<>();
    		
    		for(int i=0; i<N-1; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			int node = Integer.parseInt(st.nextToken());
    			int next = Integer.parseInt(st.nextToken());
    			list[node].add(next);
    			list[next].add(node);
    		}
    		
    		dfs();
    		
    		for(int i=2; i<=N; i++)
    			System.out.println(parent[i]);
    }
    
    private static void dfs() {
    		Stack<Integer> stack = new Stack<>();
    		visited = new boolean[N+1];
    		
    		stack.push(1);
    		visited[1] = true;
    		
    		while(!stack.isEmpty()) {
    			int node = stack.pop();
    			
    			for(int next: list[node]) {
    				if(!visited[next]) {
    					parent[next] = node;
    					stack.push(next);
    					visited[next] = true;
    				}
    			}
    		}
    }
}