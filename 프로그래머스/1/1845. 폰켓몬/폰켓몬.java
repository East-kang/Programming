import java.util.*;
class Solution {
    public static int solution(int[] nums) {
        int answer = 0;
        Set<Integer> s = new HashSet<>();
        int nLength = nums.length / 2;
        for(int n : nums) {
            s.add(n);
        }
        int len = s.size();
        
        return len <= nLength? len : nLength;
    }
}