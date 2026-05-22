import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int w : works) {
            pq.offer(w);
        }
        
        for(int i=0; i<n && !pq.isEmpty(); i++) {
            int work = pq.poll();
            
            if(work != 0) {
                pq.offer(work-1);
            }
        }
        
        while(!pq.isEmpty()) {
            int remain = pq.poll();
            answer += remain*remain;
        }
        return answer;
    }
}