import java.io.*;
import java.util.*;

public class Solution {

	static int N, W, H, map[][], temp[][], pos[];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static List<int[]> list;
	static int init_blocks, change_blocks, result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			pos = new int[N];
			list = new ArrayList<>();

			init_blocks = 0;
			result = Integer.MAX_VALUE;
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0)	init_blocks++;
				}
			}

			permutation(0);
			
			for(int[] position: list) {
				change_blocks = init_blocks;
				
				temp = new int[H][W];
				for(int i=0; i<H; i++)
					temp[i] = map[i].clone();
				
				for(int x: position)
					fallBall(x);

				result = Math.min(result, change_blocks);
			}
			
			System.out.println("#" + t + " " + result);
		}
	}

	private static void permutation(int cnt) {
		if(cnt==N) {
			list.add(Arrays.copyOf(pos, cnt));
			return;
		}
		
		for(int i=0; i<W; i++) {
			pos[cnt] = i;
			permutation(cnt+1);
		}
	}
	
	private static void fallBall(int p) {
		int cy=0, cx=p;
		
		while(cy<H) {
			if(temp[cy][cx] == 0)
				cy++;
			else {
				bomb(cy, cx);
				setGravity(cx);
				break;
			}
		}
	}

	private static void bomb(int y, int x) {
		Deque<int[]> q = new ArrayDeque<>();
		boolean visited[][] = new boolean[H][W];
		
		q.offer(new int[] {y, x});
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] position = q.poll();
			int cy = position[0];
			int cx = position[1];
			int range = temp[cy][cx]-1;
			temp[cy][cx] = 0;
			change_blocks--;
			
			for(int i=0; i<4; i++) {
				for(int j=1; j<=range; j++) {
					int ny = cy+dy[i]*j;
					int nx = cx+dx[i]*j;
					
					if(ny<0 || nx<0 || ny>=H || nx>=W || visited[ny][nx] || temp[ny][nx]==0) continue;
					
					q.offer(new int[] {ny, nx});
					visited[ny][nx] = true;
				}
			}
		}
	}
	
	private static void setGravity(int x) {
		boolean gravity[] = new boolean[W];
		
		for(int i=H-1; i>=0; i--) {
			for(int j=W-1; j>=0; j--) {
				if(temp[i][j] == 0)
					gravity[j] = true;
				else {
					if(gravity[j]) {
						int ny = i;
						while(++ny<H && temp[ny][j]==0) {}
						temp[ny-1][j] = temp[i][j];
						temp[i][j] = 0;
					}
				}
			}
		}
	}
}
