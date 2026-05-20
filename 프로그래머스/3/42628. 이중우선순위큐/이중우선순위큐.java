import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxq = new PriorityQueue<>((a, b) -> b-a);
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        int cnt = 0;
        for(String o : operations) {
            String[] order = o.split(" ");
            if(order[0].equals("I")) {
                maxq.offer(Integer.parseInt(order[1]));
                minq.offer(Integer.parseInt(order[1]));
                cnt++;
            } else {
                if(order[1].equals("1")) {
                    if(maxq.isEmpty()) {
                        continue;
                    }
                    minq.remove(maxq.poll());
                } else {
                    if(minq.isEmpty()) {
                        continue;
                    }
                    maxq.remove(minq.poll());
                }
                cnt--;
                if(cnt==0) {
                    maxq.clear();
                    minq.clear();
                }
            }
        }
        if(cnt == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = maxq.peek();
            answer[1] = minq.peek();
        }
        return answer;
    }
}