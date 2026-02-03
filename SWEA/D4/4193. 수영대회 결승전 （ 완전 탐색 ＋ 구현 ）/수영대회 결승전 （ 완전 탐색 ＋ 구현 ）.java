import java.io.*;
import java.util.*;
 
public class Solution {
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
         
        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            st = new StringTokenizer(br.readLine());
            int s_y = Integer.parseInt(st.nextToken());
            int s_x = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine());
            int e_y = Integer.parseInt(st.nextToken());
            int e_x = Integer.parseInt(st.nextToken());
             
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] v = new boolean[N][N];
             
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};
            int time = 0;
            int result = -1;
             
            // offer: {s_y, s_x} 지점으로 갈 거야
            q.offer(new int[] {s_y, s_x, time});
            v[s_y][s_x] = true;
             
            while(!q.isEmpty()) {
                // poll: {p[0], p[1]} 지점에 도착 / 시간: p[2]
                int[] p = q.poll();
                int cy = p[0];
                int cx = p[1];
                int ct = p[2];
                 
                // 현재 위치가 도착 위치와 같을 경우 ct(현재 시간) 리턴, 반복 중지
                if(cx == e_x && cy == e_y) {
                    result = ct;
                    break;
                }
                 
                for(int i=0; i<4; i++) {
                    int ny = cy+dy[i];
                    int nx = cx+dx[i];
                     
                    // 맵 범위 벗어나거나, 방문 이력 있으면 통과
                    if(nx<0 || nx>=N || ny<0 || ny>=N || v[ny][nx]) continue;
                    // 1: 장애물 만나면 통과
                    if(map[ny][nx] == 1) continue;
                    // 2: 소용돌이 만났을 때 통과 (소용돌이 존재할 시간만) { 0(x)/1(x)/2(x)/3(o)/4(x) }
                    if(map[ny][nx] == 2 && (ct+1)%3 != 0) {
                        q.offer(new int[] {cy, cx, ct+1});  // 현재 위치 재저장 (가만히 있기, 한 번 통과하면 머물기 가능)
                        continue;
                    }
                     
                    // 다음 지점으로 갈거야
                    q.offer(new int[] {ny, nx, ct+1});
                    v[ny][nx] = true;
                }
            }
             
            System.out.println("#" + t + " " + result);
        }
    }
}