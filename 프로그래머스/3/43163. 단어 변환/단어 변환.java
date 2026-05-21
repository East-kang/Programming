import java.util.*;

class Solution {
    public static int n, len, answer = Integer.MAX_VALUE;
    public static boolean vis[];
    public int solution(String begin, String target, String[] words) {
        int cnt = 0;
        n = words.length;
        len = words[0].length();
        vis = new boolean[n];
        
        recursive(begin, target, words, 0);
        return answer==Integer.MAX_VALUE ? 0 : answer;
    }
    
    public boolean recursive(String begin, String target, String[] words, int cnt) {
        if(begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return true;
        }
        
        for(int i=0; i<n; i++) {
            if(vis[i]) continue;
            
            int count = 0;
            for(int j=0; j<len; j++) {
                if(begin.charAt(j) == words[i].charAt(j)) {
                    count++;
                }
            }
            
            if(count == len-1) {
                vis[i] = true;
                recursive(words[i], target, words, cnt+1);
                vis[i] = false;
            }
        }
        return false;
    }
}