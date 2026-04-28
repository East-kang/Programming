import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = yellow + brown;
        for(int i=1; i<=(int)Math.sqrt(yellow); i++) {
            if((yellow % i == 0) && (total == ((i+2) * (yellow/i + 2)))) {
                answer[0] = yellow/i + 2;
                answer[1] = i + 2;
                break;
            }
        }
        return answer;
    }
}