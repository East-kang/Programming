/*
1. 전체 돌면서 섬 번호 부여하기 (재귀)
2. 전체 돌면서 우하 2방탐색 하면서 다리 길이 뽑으면서 최솟값 갱신 (이차원 배열: 출발->도착 = 거리)
3. Prim 알고리즘으로 최소 거리 찾기
 */

import java.io.*;
import java.util.*;

public class Main{
	static int N, M, idx, result=0, map[][], bridge[][];
	static boolean visited[][];
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};	// 하, 우, 상, 좌
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		idx=1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]!=0 && !visited[i][j]) {
					recursive(i, j, idx++);
				}
			}
		}

		bridge = new int[idx][idx];
		for(int i=1; i<idx; i++)
			Arrays.fill(bridge[i], Integer.MAX_VALUE);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]!=0) {
					for(int k=0; k<2; k++) {
						int ny = i+dy[k];
						int nx = j+dx[k];
						if(!outOfMap(ny, nx) && map[ny][nx]==0)
							make_bridges(ny, nx, k);
					}
				}
			}
		}
		
		prim();
		System.out.println(result);
	}
	
	// 맵 벗어나기 여부
	private static boolean outOfMap(int y, int x) {
		return (x<0 || y<0 || x>=M || y>=N);
	}
	
	// 섬 번호 메기기
	private static void recursive(int y, int x, int num) {
		map[y][x] = num;
		visited[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(outOfMap(ny, nx) || visited[ny][nx] || map[ny][nx] == 0) continue;
			recursive(ny, nx, num);
		}
	}
	
	// 다리 길이 구하기
	private static void make_bridges(int y, int x, int dir) {
		int len=0;
		int start=map[y-dy[dir]][x-dx[dir]];
		
		while(!outOfMap(y, x)) {
			if(map[y][x]!=0) {
				if(map[y][x] == start)
					break;
				if(len>1) {
					int end = map[y][x];
					bridge[start][end] = Math.min(bridge[start][end], len);
					bridge[end][start] = Math.min(bridge[end][start], len);
				}
				break;
			}
			len++;
			if(dir==0) y++;
			else x++;
		}
	}
	
	// prim 알고리즘
	private static void prim() {
		boolean[] v = new boolean[idx];
		int[] distance = new int[idx];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		for(int i=1; i<idx; i++) {
			int minIdx = -1;
			int minD = Integer.MAX_VALUE;
			for(int j=1; j<idx; j++) {
				if(!v[j] && distance[j] < minD) {
					minD = distance[j];
					minIdx = j;
				}
			}
			
			if(minIdx == -1) {
				result = -1;
				return;
			}
			v[minIdx] = true;
			
			for(int j=1; j<idx; j++) {
				if(minIdx!=j && !v[j] && bridge[minIdx][j]<Integer.MAX_VALUE)
					distance[j] = Math.min(distance[j], bridge[minIdx][j]);
			}
		}
		
		for(int i=1; i<idx; i++) {
			result += distance[i];
		}
	}
}
