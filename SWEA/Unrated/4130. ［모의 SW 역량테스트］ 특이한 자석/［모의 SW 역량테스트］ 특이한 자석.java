import java.io.*;
import java.util.*;

public class Solution {
	static int magnet = 4;							// 자석 갯수
	static int[][] chain = new int[magnet+1][8];	// 1~4번 자석 자성값 배열
	static int[][] side = new int[magnet+1][2];		// 1~4번 서로 맞닿는 부분 인덱스 저장 배열 (side[][0]: 좌측, side[][1]: 우측)
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int K = Integer.parseInt(br.readLine());
			
			for(int i=1; i<=magnet; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					chain[i][j] = Integer.parseInt(st.nextToken());
				}
				
				side[i][0] = 6;	// 좌(6번 인덱스)
				side[i][1] = 2;	// 우(2번 인덱스)
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int M = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				
				rotation(M, R, 0);
			}

			System.out.println("#" + t + " " + scoring());
		}
	}
	
	// M번째 자석을 R 방향으로 회전하기
	public static void rotation(int M, int R, int dir) {
		// 좌측 자석 회전
		if(M>1 && dir<=0)
			if(chain[M][side[M][0]] != chain[M-1][side[M-1][1]])
				rotation(M-1, -R, -1);
		
		// 우측 자석 회전
		if(M<magnet && dir>=0)
			if(chain[M][side[M][1]] != chain[M+1][side[M+1][0]])
				rotation(M+1, -R, 1);
		
		// 회전에 따른 자석 회전 후 자성값 갱신
		if(R==1) {
			side[M][0] = (side[M][0]+7)%8;
			side[M][1] = (side[M][1]+7)%8;
		} else {
			side[M][0] = (side[M][0]+1)%8;
			side[M][1] = (side[M][1]+1)%8;
		}
	}
	
	// 점수 계산
	public static int scoring() {
		int sum = 0;
		for(int i=1; i<=magnet; i++)
			if(chain[i][(side[i][1]+6)%8] == 1)	// 우측 자성 인덱스로부터 두 칸전이 S인지 확인
				sum += Math.pow(2,i-1);
		return sum;
	}
}