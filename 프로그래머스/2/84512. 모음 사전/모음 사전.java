import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        String str = "AEIOU";
        int[] weight = {781, 156, 31, 6, 1};
        
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int idx = str.indexOf(c);
            
            answer += idx*weight[i] + 1;
        }
        return answer;
    }
}