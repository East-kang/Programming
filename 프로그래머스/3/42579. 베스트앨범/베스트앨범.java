import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        PriorityQueue<Genre> pq = new PriorityQueue<>((a, b) -> b.total - a.total);
        Map<String, Genre> map = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            String genre = genres[i];
            if(map.containsKey(genre)) {
                int total = map.get(genre).total;
                int id1 = map.get(genre).id1st;
                int id2 = map.get(genre).id2nd;
                
                total += plays[i];
                if(id1 == -1) {
                    id1 = i;
                } else {
                    if(plays[id1] < plays[i]) {
                        id2 = id1;
                        id1 = i;
                    } else {
                        if(id2 == -1 || plays[id2] < plays[i]) id2 = i;
                    }
                }
                map.put(genre, new Genre(genre, total, id1, id2));
            } else {
                map.put(genre, new Genre(genre, plays[i], i, -1));
            }
        }
        
        int cnt = 0;
        for(String genre : map.keySet()) {
            pq.offer(map.get(genre));
            if(map.get(genre).id1st != -1)
                cnt++;
            if(map.get(genre).id2nd != -1)
                cnt++;
        }
        
        int[] answer = new int[cnt];
        int idx = 0;
        while(!pq.isEmpty()) {
            Genre g = pq.poll();
            if(map.get(g.key).id1st != -1)
                answer[idx++] = map.get(g.key).id1st;
            if(map.get(g.key).id2nd != -1)
                answer[idx++] = map.get(g.key).id2nd;
        }
        return answer;
    }
}

class Genre {
    String key;
    int total, id1st, id2nd;
    public Genre(String key, int total, int id1st, int id2nd) {
        this.key = key;
        this.total = total;
        this.id1st = id1st;
        this.id2nd = id2nd;
    }
}