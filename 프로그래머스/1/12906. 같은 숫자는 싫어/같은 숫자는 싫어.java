import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int a : arr) {
            if(dq.isEmpty() || dq.peekLast() != a)
                dq.offer(a);
        }
        
        int[] answer = new int[dq.size()];
        int idx = 0;
        while(!dq.isEmpty()) {
            answer[idx++] = dq.poll();
        }

        return answer;
    }
}