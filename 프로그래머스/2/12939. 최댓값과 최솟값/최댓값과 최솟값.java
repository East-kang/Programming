import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split(" ");
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(String w : words) {
            int n = Integer.parseInt(w);
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        answer += min + " " + max;
        return answer;
    }
}