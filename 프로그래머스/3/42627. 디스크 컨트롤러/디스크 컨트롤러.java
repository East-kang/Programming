import java.util.*;

class Solution {
    public class Task implements Comparable<Task>{
        int num, req, time;
        Task(int num, int req, int time) {
            this.num = num;
            this.req = req;
            this.time = time;
        }
        
        @Override
        public int compareTo(Task a) {
            if(this.time != a.time) { return this.time - a.time; }
            if(this.req != a.req)   { return this.req - a.req; }
            if(this.num != a.num)   { return this.num - a.num; }
            return 0;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        int idx = 0, time = 0, cnt = 0, N = jobs.length;
        Task[] tasks = new Task[N];
        
        for(int i=0; i<N; i++) {
            tasks[i] = new Task(i, jobs[i][0], jobs[i][1]);
        }
        
        PriorityQueue<Task> pq = new PriorityQueue<>();
        Arrays.sort(tasks, (a, b) -> a.req - b.req);
        time = tasks[idx].req;
        while(cnt < N) {
            while(idx < N && tasks[idx].req <= time) {
                pq.offer(tasks[idx++]);
            }
            
            Task t = !pq.isEmpty()? pq.poll() : tasks[idx++];
            time = Math.max(t.req, time) + t.time;
            cnt++;
            answer += (time - t.req);
        }
        return answer/cnt;
    }
}