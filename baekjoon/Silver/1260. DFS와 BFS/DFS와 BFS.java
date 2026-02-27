import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] map = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            map[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            map[v].add(u);
            map[u].add(v);
        }

        for(int i=1; i<=N; i++) {
            Collections.sort(map[i]);
        }
        
        // DFS (stack, pop visited write)
        StringBuilder dfs = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[N+1];

        s.push(V);
        while(!s.isEmpty()) {
            int u = s.pop();
            if(visited[u]) continue;
            visited[u] = true;
            dfs.append(u).append(' ');

            for(int i=map[u].size()-1; i>=0; i--) {
                int next = map[u].get(i);
                if(!visited[next]) {
                    s.push(next);
                }
            }
        }

        // BFS (Deque, offer visited, poll write)
        StringBuilder bfs = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();
        visited = new boolean[N+1];

        q.offer(V);
        visited[V] = true;
        while(!q.isEmpty()) {
            int u = q.poll();
            bfs.append(u).append(' ');
            for(int v : map[u]) {
                if(!visited[v]) {
                    q.offer(v);
                    visited[v] = true;
                }
            }
        }

        bw.write(dfs.toString().trim() + "\n" + bfs.toString().trim());
        bw.close();
    }
}