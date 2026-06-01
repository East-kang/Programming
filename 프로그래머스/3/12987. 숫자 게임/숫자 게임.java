import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int a = 0, b = 0;
        int n = B.length;
        boolean used[] = new boolean[n];
        
        Arrays.sort(A);
        Arrays.sort(B);
        while(a < n && b < n) {
            if(A[a] < B[b]) {
                a++;
                answer++;
            }
            b++;
        }
        
        return answer;
    }
}