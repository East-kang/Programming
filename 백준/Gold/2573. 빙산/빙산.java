import java.io.*;
import java.util.*;
public class Main {

	public static class Ice {
		int y, x, height;

		public Ice(int y, int x, int height) {
			this.y = y;
			this.x = x;
			this.height = height;
		}
	}
	static List<Ice> list;
	static int N, M, map[][], tmp[][], time, cnt, ice;
	static boolean vis[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tmp = new int[N][M];
		list = new ArrayList();
		time = cnt = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value != 0) {
					list.add(new Ice(i, j, value));
					cnt++;
				}
				map[i][j] = value;
				tmp[i][j] = value;
			}
		}
		
		while(true) {
			vis = new boolean[N][M];
			ice = 0;
		
			meltIce();
			
			if(list.isEmpty()) {
				System.out.println(0);
				break;
			}
			confirmDevide(list.get(0).y, list.get(0).x);
			time++;
			
			if(ice != cnt) {
				System.out.println(time);
				break;
			}
		}
	}
	
	private static boolean isOut(int y, int x) {
		return (y<0 || x<0 || y>=N || x>=M);
	}

	private static void meltIce() {
		List<Ice> tmpList = new ArrayList<>();
		
		for(Ice p : list) {
			for(int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if(isOut(ny, nx)) continue;
				if(map[ny][nx] == 0) p.height--;
				if(p.height == 0) {
					cnt--;
					break;
				}
			}
		}
		
		for(Ice p : list) {
			map[p.y][p.x] = tmp[p.y][p.x]= p.height;  
			if(p.height != 0)	tmpList.add(p);
		}
		list = new ArrayList<>(tmpList);
	}
	
	private static void confirmDevide(int y, int x) {
		if(isOut(y, x) || vis[y][x] || map[y][x] == 0) return;
		
		ice++;
		vis[y][x] = true;
		for(int i=0; i<4; i++)
			confirmDevide(y + dy[i], x + dx[i]);
	}
}