import java.io.*;
import java.util.*;
public class Solution {

	static class Point {
		int y, x, step;
		boolean up, down, right, left;
		
		public Point(int y, int x, int step, boolean up, boolean down, boolean right, boolean left) {
			this.y = y;		this.x = x;		this.step = step;
			this.up = up;		this.down = down;
			this.right = right;	this.left = left;
		}
	}
	
	static int N, M, R, C, L, cnt;
	static Point[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new Point[N][M];
			cnt = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					int type = Integer.parseInt(st.nextToken());
					map[i][j] = curPos(i, j, type);
				}
			}
			
			bfs(R, C);
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	private static Point curPos(int y, int x, int type) {
		boolean up = false, down = false, right = false, left = false;
		if(type == 1)		up = down = right = left = true;
		else if(type == 2)	up = down = true;
		else if(type == 3)	right = left = true;
		else if(type == 4)	up = right = true;
		else if(type == 5)	down = right = true;
		else if(type == 6)	down = left = true;
		else if(type == 7)	up = left = true;
		return new Point(y, x, 1, up, down, right, left);
	}
	
	// 상,하,좌,우 : 0,1,2,3
	private static boolean isConnected(Point prev, Point cur, int dir) {
		if( (dir == 0 && prev.up && cur.down) ||
			(dir == 1 && prev.down && cur.up) ||
			(dir == 2 && prev.left && cur.right) ||
			(dir == 3 && prev.right && cur.left)) return true;
		return false;
	}
	
	private static boolean isIn(int y, int x) {
		return (y<0 || x<0 || y>=N || x>=M);
	}
	
	private static void bfs(int y, int x) {
		Deque<Point> dq = new ArrayDeque<>();
		boolean[][] vis = new boolean[N][M];
		dq.offer(map[y][x]);
		vis[y][x] = true;
		cnt++;
		while(!dq.isEmpty()) {
			Point p = dq.poll();
			int cy = p.y;	int cx = p.x;	int cStep = p.step;		int nStep = cStep+1;
			
			for(int dir=0; dir<4; dir++) {
				int ny = cy + dy[dir];
				int nx = cx + dx[dir];
				if(isIn(ny, nx) || vis[ny][nx] || nStep > L)	continue;
				if(!isConnected(map[cy][cx], map[ny][nx], dir)) continue;
				vis[ny][nx] = true;
				cnt++;
				map[ny][nx].step = nStep;
				dq.offer(map[ny][nx]);
			}
		}
	}
}
