import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int depth = triangle.length;
        for(int i=1; i<depth; i++) {
            int width = triangle[i].length;
            for(int j=0; j<width; j++) {
                if(j == 0) {
                    triangle[i][j] += triangle[i-1][j];
                } else if(j == width-1) {
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
                
                if(i == depth-1) {
                    answer = Math.max(answer, triangle[i][j]);
                }
            }
        }
        return answer;
    }
}