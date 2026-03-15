import java.io.*;
import java.util.*;
public class Solution {

	static int N, W, H, map[][], temp[][], arr[], blocks, result, cnt;
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			temp = new int[H][W];
			arr = new int[N];
			blocks = 0;
			result = Integer.MAX_VALUE;
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > 0)	blocks++;
				}
			}
			
			permutation(0);
			
			System.out.println("#" + t + " " + result);
		}
	}

	private static void ballFall(int pos) {
		for(int y=0; y<H; y++) {
			if(temp[y][pos] > 0) {
				bomb(y, pos);
				setGravity();
				break;
			}
		}
	}

	private static void setGravity() {
		Deque<Integer> q = new ArrayDeque<>();
		for(int x=0; x<W; x++) {
			int ey = H-1;	boolean gravity = false;
			for(int y=H-1; y>=0; y--) {
				if(!gravity && temp[y][x]==0) { gravity=true;  ey=y; }
				if(gravity && temp[y][x] > 0) {
					q.offer(temp[y][x]);
					temp[y][x] = 0;
				}
			}
			while(!q.isEmpty()) { temp[ey--][x] = q.poll(); }
		}
	}

	private static void bomb(int y, int x) {
		Deque<int[]> q = new ArrayDeque<>();
		boolean visited[][] = new boolean[H][W];
		q.offer(new int[] {y, x});
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			int start[] = q.poll();
			int cy = start[0];
			int cx = start[1];
			int range = temp[cy][cx]-1;
			temp[cy][cx] = 0;
			cnt--;
			
			for(int i=0; i<4; i++) {
				for(int j=1; j<=range; j++) {
					int ny = cy + dy[i] * j;
					int nx = cx + dx[i] * j;
					if(ny<0 || nx<0 || ny>=H || nx>=W || visited[ny][nx] || temp[ny][nx]==0) continue;
					q.offer(new int[] {ny, nx});
					visited[ny][nx] = true;
				}
			}
		}
	}

	private static void permutation(int count) {
		if(count == N) {
			cnt = blocks;
			for(int i=0; i<H; i++)
				temp[i] = map[i].clone();
			for(int pos : arr)
				ballFall(pos);
			result = Math.min(result, cnt);
			return;
		}
		
		for(int i=0; i<W; i++) {
			arr[count] = i;
			permutation(count+1);
		}
	}
}
