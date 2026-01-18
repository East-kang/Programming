import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for (int test=1; test<=T; test++) {
    		bw.write("#"+ test +" ");
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int x=-1, y=-1;
            int dir_x = 0;
            int dir_y = 0;
            
            char[][] map = new char[H][W];
            for (int i=0; i<H; i++) {
                String line = br.readLine();
                for (int j=0; j<W; j++) {
                    map[i][j] = line.charAt(j);
                }
                for (int j=0; j<W; j++) {
                    char ch = map[i][j];
                    if (ch == '>' || ch == '<' || ch == '^' || ch == 'v') {
                        x = j;	y = i;
                        if (ch == '>') { dir_x = 1; dir_y = 0; }
                        else if (ch == '<') { dir_x = -1; dir_y = 0; }
                        else if (ch == '^') { dir_x = 0; dir_y = -1; }
                        else { dir_x = 0; dir_y = 1; }
                    }
                }
            }
            
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            for (int i=0; i<N; i++) {
                switch (str.charAt(i)) {
                    case 'U':
                        dir_x = 0;	dir_y = -1;  map[y][x] = '^';
                    	if (y > 0 && map[y-1][x] == '.') {
                            map[y--][x] = '.';
                            map[y][x] = '^';
                        }
                        break;
                    case 'D':
                        dir_x = 0;	dir_y = 1;  map[y][x] = 'v';
                        if (y < H-1 && map[y+1][x] == '.') {
                            map[y++][x] = '.';
                            map[y][x] = 'v';
                        }
                        break;
                    case 'L':
                        dir_x = -1;	dir_y = 0;  map[y][x] = '<';
                        if (x > 0 && map[y][x-1] == '.') {
                            map[y][x--] = '.';
                            map[y][x] = '<';
                        }
                        break;
                    case 'R':
                        dir_x = 1;	dir_y = 0;  map[y][x] = '>';
                        if (x < W-1 && map[y][x+1] == '.') {
                            map[y][x++] = '.';
                            map[y][x] = '>';
                        }
                        break;
                    case 'S':
                        if (dir_x == -1) {
                            for (int j=x-1; j>=0; j--) {
                                if (map[y][j] == '*') {
                                    map[y][j] = '.';
                                    break;
                            	} else if (map[y][j] == '#')
                                    break;
                            }
                        } else if (dir_x == 1) {
                            for (int j=x+1; j<W; j++) {
                                if (map[y][j] == '*') {
                                    map[y][j] = '.';
                                    break;
                            	} else if (map[y][j] == '#')
                                    break;
                            }
                        } else if (dir_y == -1) {
                            for (int j=y-1; j>=0; j--) {
                                if (map[j][x] == '*') {
                                    map[j][x] = '.';
                                    break;
                            	} else if (map[j][x] == '#')
                                    break;
                            } 
                        } else {
                        	for (int j=y+1; j<H; j++) {
                                if (map[j][x] == '*') {
                                    map[j][x] = '.';
                                    break;
                            	} else if (map[j][x] == '#')
                                    break;
                            }
                        }
                }
            }
            
            for (int i=0; i<H; i++) {
                for (int j=0; j<W; j++) {
                    bw.write(map[i][j]);
                }
                bw.write("\n");
            }
        }
        bw.close();
    }
}