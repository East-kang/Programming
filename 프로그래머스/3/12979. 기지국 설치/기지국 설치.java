import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int bw = w*2+1;
        int left, right;
        
        for(int station: stations) {
            left = (station - w >= 1 ? station - w : 0);
            right = (station + w <= n ? station + w : n);
            answer += ((left - start) / bw);
            if((left - start) % bw > 0) {
                answer++;
            }
            start = right + 1;
        }
        
        if(start <= n) {
            answer += ((n - start + 1) / bw);
            if((n - start + 1) % bw > 0) {
                answer++;
            }
        }
        return answer;
    }
}