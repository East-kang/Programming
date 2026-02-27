import java.io.*;
import java.util.*;

/*
 * 1. comb() : 1~N/2까지 갯수 뽑아서 두 그룹 만들기(그룹은 true/false로 분할)
 * 2. check(): 목표 갯수 뽑으면 check()로 a,b 그룹 분할 유효성 확인(그룹의 점이 0개가 아닌지 확인하는 작업)
 * 			   각 그룹 연결성 여부(dfs)와 인구 수 합 구하기
 * 3. dfs()  : 같은 그룹만 검색
 */
public class Main {
	static int N, weight[], sum, cnt, min=Integer.MAX_VALUE;
	static List<Integer>[] adj;
	static boolean sel[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		weight = new int[N+1];
		
		// 인구 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		// 인접 정점 리스트
		adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int near = Integer.parseInt(st.nextToken());
			for(int j=0; j<near; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		sel = new boolean[N+1];
		for(int i=0; i<=N/2; i++) {
			comb(1, 0, i);
		}
		
		if(min<Integer.MAX_VALUE)
			System.out.println(min);
		else
			System.out.println(-1);
	}
	
	private static void comb(int start, int cnt, int i) {
		if(cnt == i) {
			check();
			return;
		}
		if(start>N) return;
		
		sel[start] = true;
		comb(start+1, cnt+1, i);
		sel[start] = false;
		comb(start+1, cnt, i);
	}

	private static void check() {
		int startA = -1, startB = -1;
		int cntA = 0, cntB = 0;
		
		for(int i=1; i<=N; i++) {
			if(sel[i]) {
				startA = i;
				cntA++;
			} else {
				startB = i;
				cntB++;
			}
		}
		
		if(startA==-1 || startB==-1) return;
		
		boolean[] visA = new boolean[N+1];
		sum = cnt = 0;
		dfs(startA, true, visA);
		if(cnt != cntA) return;
		int sumA = sum;
		
		boolean[] visB = new boolean[N+1];
		sum = cnt = 0;
		dfs(startB, false, visB);
		if(cnt != cntB) return;
		int sumB = sum;
		
		min = Math.min(min, Math.abs(sumA-sumB));
	}

	private static void dfs(int cur, boolean type, boolean[] vis) {
		vis[cur]=true;
		cnt++;
		sum += weight[cur];
		for(int x: adj[cur]) {
			if(sel[x] != type) continue;
			if(vis[x]) continue;
			dfs(x, type, vis);
		}	
	}
}