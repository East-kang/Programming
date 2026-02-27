import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D, map[][], archers_x[], kill;
	static List<int[]> archer_position;
	static int[] dx = {-1, 0, 1};
	static int[] dy = {0, -1, 0};	// 0: 좌 , 1: 상 , 2: 우
	static int attackX, attackY;		// 적을 발견한 가장 가까운 좌표
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		archers_x = new int[3];				// 세 궁수의 x 좌표 배열
		archer_position = new ArrayList<>();// 위 배열의 조합을 담을 리스트	
		position_combination(0, 0);			// 궁수의 위치 조합
		
		// 궁수의 위치에 따른 공격 전부 조회
		for(int[] archer : archer_position) {
			int enemy_line = N-1;			// 적을 보는 행 인덱스
			int current_kill = 0;			// 현재 궁수 위치에서의 적 처치 횟수
			
			int[][] tmp = new int[N][M];	// 적 사망(1->0)을 표기하기 위한 임시 map
			for(int i=0; i<N; i++)
				tmp[i] = map[i].clone();
			
			while(enemy_line >= 0) {
				for(int i=0; i<3; i++) {		    // 세 궁수의 공격 BFS
					attackY = -1;					// 죽을 적의 지점 임의 초기화
					kill_enemy(tmp, enemy_line, archer[i]);	// (archer[i], enemy_line)부터 겨냥하겠음. 적을 D 거리까지 찾으면서 보이면 왼쪽부터 사살.
					
					if(attackY != -1)	tmp[attackY][attackX]++;	// 좌표 값이 바뀌었다 -> 적을 찾았다 -> 적 사살 표시(값 증가)
				}
              
				for(int i=0; i<=enemy_line; i++)    // 죽인 적 카운팅, 죽으면 초기화(0)
					for(int j=0; j<M; j++)
						if(tmp[i][j] > 1) {
							current_kill++;
							tmp[i][j] = 0;
						}
				enemy_line--;	// 적 이동
            }
			kill = Math.max(kill, current_kill);
		}
		System.out.println(kill);
	}

	// 궁수의 위치: 0~M-1까지 조합을 활용해 발생할 수 있는 위치 전부 저장.
	private static void position_combination(int start, int cnt) {
		if(cnt==3) {    // basis part: 3자리 선정했을 때
			archer_position.add(Arrays.copyOf(archers_x, 3));
			return;
		}

		for(int i=start; i<M; i++) {
			archers_x[cnt] = i;
			position_combination(i+1, cnt+1);
		}
	}
	
	// 적군을 가장 왼쪽부터 죽이는 반복문 (bfs) (적군을 동시에 죽일 수 있으므로 적군을 만나면 +1, 이후 라인 이동 시 1보다 큰 값이 있으면 죽은걸로 판별, 즉 살아있는 경우는 1일때일뿐)
	private static void kill_enemy(int[][] map, int y, int x) {
		if(map[y][x] > 0) {
			attackX = x;
			attackY = y;
			return;
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		q.offer(new int[] {y,x,1});
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int cy = point[0];
			int cx = point[1];
			int cdepth = point[2];
			
			if(map[cy][cx] > 0) {
				attackX = cx;
				attackY = cy;
				return;
			}
			
			for(int i=0; i<3; i++) {	// 좌->상->우 순으로 재귀 탐색
				int ny = cy+dy[i];
				int nx = cx+dx[i];
				int ndepth = cdepth+1;
				
				if(ndepth > D) break;
				if(nx<0 || ny<0 || nx>=M || ny>=N || visited[ny][nx]) continue;
				
				if(map[ny][nx] > 0) {
					attackX = nx;
					attackY = ny;
					return;
				}
				q.offer(new int[] {ny, nx, ndepth});
				visited[ny][nx] = true;
			}
		}
	}
}