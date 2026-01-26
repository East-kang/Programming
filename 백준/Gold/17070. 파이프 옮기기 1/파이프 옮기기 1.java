import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    static int[][] direction = {{0,1}, {0,1,2}, {1,2}};    // (0:가로, 1: 대각선, 2: 세로)
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        recursive(map, 0, 0, 1);

        bw.write(Integer.toString(count));
        bw.close();
    }

    /*
    @param map: 집
    @param dir: 파이프 방향 (0:가로, 1: 대각선, 2: 세로)
    @param y: 이동한 y축 위치 (파이프 끝 좌표)
    @param x: 이동한 x축 위치 (파이프 끝 좌표)
    */
    static void recursive(int[][] map, int dir, int y, int x) {
        
        if(y > map.length-1 || x > map[0].length-1) {
            return;
        }

        if(dir == 1){
            if(map[y][x] == 1 || map[y-1][x] == 1 || map[y][x-1] == 1){
                return;
            }
        } else {
            if(map[y][x] == 1) {
                return;
            }
        }
                
        if(y == map.length-1 && x == map[0].length-1) 
            count++;

        // 회전
        for(int d : direction[dir]) {
            int nx = x;
            int ny = y;
            if (d == 0)       {nx++;}
            else if (d == 1)  {nx++; ny++;}
            else              {ny++;}
            
            recursive(map, d, ny, nx);
        }
    }
}