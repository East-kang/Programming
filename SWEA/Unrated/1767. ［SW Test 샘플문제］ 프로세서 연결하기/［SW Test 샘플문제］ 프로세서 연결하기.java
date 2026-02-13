import java.io.*;
import java.util.*;

public class Solution {
	static int N, map[][], min_length, max_core;
	static boolean visited[][];
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static List<int[]> cores;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			min_length = Integer.MAX_VALUE;
			max_core = Integer.MIN_VALUE;
			cores = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(map[i][j] == 1) {
						if(i%(N-1)!=0 && j%(N-1)!=0)
							cores.add(new int[] {i, j});
					}
				}
			}
			connect_Core(0, 0, 0);
			System.out.println("#" + tc + " " + min_length);
		}

	}
	
	// core 연결 완전 탐색(재귀)
	private static void connect_Core(int core_num, int sum_length, int core_Cnt) {
        if(cores.size()-core_num < max_core-core_Cnt)
			return;
		if(core_num==cores.size()) {
			if(max_core<core_Cnt) {
				max_core = core_Cnt;
				min_length = sum_length;
			} else if(max_core == core_Cnt)
				min_length = Math.min(min_length, sum_length);
			return;
		}
		int y = cores.get(core_num)[0];
		int x = cores.get(core_num)[1];
		
		connect_Core(core_num+1, sum_length, core_Cnt);
		
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			int length = 0;
			
			// 확장 가능 여부 탐색
			int sy, ey, sx, ex;
			boolean isExtend = true;
			if(i==0) 	  { sy = 0;		ey = y-1;	sx = x;		ex = x; }		// 상
			else if(i==1) { sy = y;		ey = y;		sx = x+1;	ex = N-1; }		// 우
			else if(i==2) { sy = y+1;	ey = N-1;	sx = x;		ex = x; }		// 하
			else 		  { sy = y;		ey = y;		sx = 0;		ex = x-1; }		// 좌
			
			for(int j=sy; j<=ey && isExtend; j++) {
				for(int k=sx; k<=ex; k++) {
					if(map[j][k]!=0) {
						isExtend = false;
						break;
					}
				}
			}
			
			if(isExtend) {
				for(int j=sy; j<=ey; j++) {
					for(int k=sx; k<=ex; k++) {
						length++;
						map[j][k] = 2;
					}
				}
				core_Cnt++;
			}
			
			connect_Core(core_num+1, sum_length+length, core_Cnt);
			
			if(isExtend) {
				core_Cnt--;
				for(int j=sy; j<=ey; j++) {
					for(int k=sx; k<=ex; k++) {
						map[j][k] = 0;
					}
				}
			}
		}
	}
}