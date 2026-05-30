import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int start = Integer.MIN_VALUE, end = Integer.MIN_VALUE;
        for(int[] route : routes) {
            if(route[0] <= end) continue;
            start = route[0];
            end = route[1];
            answer++;
        }
        return answer;
    }
}