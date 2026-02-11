import java.io.*;
import java.util.*;
public class Main {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};	// 0:상, 1:우, 2:하, 3:좌
	static int N, M, island_Cnt=0, map[][], bridges[][][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		island_Cnt = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 개수 구하기
		boolean[][] visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j] == 1)
					islandCnt(map, visited, i, j, ++island_Cnt);
			}
		}
		
		// 섬 테두리(edges) 저장(배열+리스트)
		List<int[]>[] edges = get_edges_list();
		
		// 다리[출발 섬 번호][도착 섬 번호][방향] = 거리
		bridges = make_bridges(edges);
		
		// 섬 연결 여부 확인(BFS)
		if(!bfs()) {
			bw.write("-1");
		} else {
			// 최단 거리 구하기 (prim)
			bw.write(prim());
		}
		bw.close();
	}
	
	// 섬 개수 구하기
	private static void islandCnt(int[][] map, boolean[][] visited, int y, int x, int num) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y,x});
		visited[y][x] = true;
		map[y][x] = num;
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int cy = point[0];
			int cx = point[1];
			
			for(int i=0; i<4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				
				if(nx<0 || ny<0 || nx>=M || ny>=N || visited[ny][nx] || map[ny][nx]==0) continue;
				q.offer(new int[] {ny, nx});
				visited[ny][nx] = true;
				map[ny][nx] = num;
			}
		}
	}

	// 섬 테두리(edges) 반환(배열+리스트+배열)
	private static List<int[]>[] get_edges_list() {
		List<int[]>[] edges = new ArrayList[island_Cnt+1];
		for(int i=1; i<=island_Cnt; i++) {
			edges[i] = new ArrayList<>();
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<4; k++) {
						if(map[i][j] > 0) {
						int ny = i+dy[k];
						int nx = j+dx[k];
						if(nx<0 || ny<0 || nx>= M || ny>= N || map[ny][nx]!=0) continue;
						
						// map[i][j]: 섬 번호 / edges -> {a,b,c}: a(y좌표), b(x좌표), c(다리방향)
						edges[map[i][j]].add(new int[] {ny, nx, k});	// (k+2)%4 : 좌표 기준 섬->아래(2), 다리 방향->상(0)
					}
				}
			}
		}
		return edges;
	}
	
	// 섬 사이 최단거리 다리 만들기
	private static int[][][] make_bridges(List<int[]>[] edges) {
		int[][][] bridges = new int[island_Cnt+1][island_Cnt+1][4];
		for(int i=1; i<=island_Cnt; i++) {
			for(int j=1; j<=island_Cnt; j++)
				Arrays.fill(bridges[i][j], Integer.MAX_VALUE);
		}
		
		for(int i=1; i<=island_Cnt; i++) {
			for(int[] point: edges[i]) {
				int y = point[0], x = point[1], dir = point[2];
				int length = 1;
				// 다리 생성
				while(true) {
					switch (dir) {
					case 0: y--; break;
					case 1: x++; break;
					case 2: y++; break;
					case 3: x--; break;
					}
					if(x<0 || y<0 || M<=x || N<=y) break;
					
					if(map[y][x] == 0) {
						length++;
					} else {
						if(length > 1) {
							if(bridges[i][map[y][x]][dir] > length) {
								bridges[i][map[y][x]][dir] = length;
							}
						}
						break;
					}
				}
			}
		}
		return bridges;
	}
	
	// 연결 여부 확인 (BFS)
		private static boolean bfs() {
			Queue<Integer> q = new ArrayDeque<>();
			boolean[] visited = new boolean[island_Cnt+1];	 // 섬 방문 여부
			q.offer(1);
			visited[1] = true;
			while(!q.isEmpty()) {
				int land = q.poll();
				
				for(int i=1; i<=island_Cnt; i++) {
					for(int j=0; j<4; j++) {
						if(!visited[i] && bridges[land][i][j] < Integer.MAX_VALUE) {
							q.offer(i);
							visited[i] = true;
							break;
						}
						if(visited[i])
							break;
					}
				}
			}
			
			// 모든 섬 방문 여부
			for(int i=1; i<=island_Cnt; i++)
				if(!visited[i])
					return false;
			return true;
		}
	
	// 최단거리 구하기 (Prim)
	private static String prim() {
		// 인접 리스트 구현
		List<int[]>[] adj = new ArrayList[island_Cnt+1];
		for(int i=1; i<=island_Cnt; i++) {
			adj[i] = new ArrayList<>();
		}
		
		// 인접 리스트(양방향)
		for(int i=1; i<=island_Cnt; i++) {
			for(int j=1; j<=island_Cnt; j++) {
				for(int k=0; k<4; k++) {
					if(bridges[i][j][k] != Integer.MAX_VALUE) {
						adj[i].add(new int[] {j, bridges[i][j][k]});	// i섬 -> j섬 : weight=bridges[i][j][k]
					}
				}
			}
		}
		
		int[] distance = new int[island_Cnt+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean[] visited = new boolean[island_Cnt+1];
		
		distance[1] = 0;
		for(int i=1; i<=island_Cnt; i++) {
			int minIdx = -1;
			int minD = Integer.MAX_VALUE;
			for(int j=1; j<=island_Cnt; j++) {
				if(!visited[j] && distance[j] < minD) {
					minIdx = j;
					minD = distance[j];
				}
			}
			
			visited[minIdx] = true;
			for(int[] island: adj[minIdx]) {
				int land_num = island[0];
				int weight = island[1];
				if(!visited[land_num] && weight<distance[land_num]) {
					distance[land_num] = weight;
				}
			}
		}
		
		int sum = 0;
		for(int i=1; i<=island_Cnt; i++) 
			sum += distance[i];
		
		return Integer.toString(sum);
	}
}
