import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int idx = 0;
        if(s / n < 1) {
            return new int[] {-1};
        } else {
            for(int i=0; i<n; i++) {
                answer[i] = s/(n-i);
                s -= answer[i];
            }
            return answer;
        }
    }
}