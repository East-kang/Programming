import java.util.*;

// 1. DFS
class Solution {
    static List<Integer>[] list;
    static boolean[] vis;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        list = new ArrayList[n];
        
        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(computers[i][j] == 1) {
                    list[i].add(j);
                }
            }
        }
        
        vis = new boolean[n];
        for(int i=0; i<n; i++){
            if(!vis[i]) {
                recursive(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void recursive(int n) {
        for(int near : list[n]) {
            if(!vis[near]) {
                vis[near] = true;
                recursive(near);
            }
        }
    }
}

// 2. Union-find
// class Solution {
//     public int solution(int n, int[][] computers) {
//         int answer = 0;
//         return answer;
//     }
// }