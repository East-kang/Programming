import java.io.*;
import java.util.*;

public class Solution {
	static int win, lose;
	static int card_n = 18;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int[] card = new int[card_n+1];
			boolean[] v = new boolean[card_n+1];
			for(int i=1; i<=card_n; i++)
				card[i] = i;

			int[] A = new int[card_n/2+1];
			
			st = new StringTokenizer(br.readLine());
			int[] score = new int[2];
			win = lose = 0;
			for(int i=1; i<=card_n/2; i++) {
				int n = Integer.parseInt(st.nextToken());
				A[i] = n;
				v[n] = true;
			}
			
			game(A, v, score, 1);
			
			bw.write("#"+t+" "+win+" "+lose+"\n");
		}
		bw.close();
	}

	public static void game(int[] A, boolean[] v, int[] score, int idx) {
		// B의 카드를 다 썼을 때: 게임 끝났을 때 점수 승패 결정!
		if(idx>card_n/2) {
			if(score[0] > score[1])
				win++;
			else if(score[0] < score[1])
				lose++;
			return;
		}
		// B의 카드를 하나씩 뽑아서 A와 비교
		// 방문 여부에 따라 B의 카드와 비교(재귀)
		for(int i=1; i<=card_n; i++) {
			if(v[i]) continue;
			int[] tmp = Arrays.copyOf(score, 2);
			v[i] = true;
			game(A, v, check_Score(tmp, A[idx], i), idx+1);
			v[i] = false;
		}
	}

	// 카드 비교 검증 함수: 점수 반환. [0]:A, [1]:B
	public static int[] check_Score(int[] score, int A, int B) {
		if(A>B)
			score[0] += A+B;
		else
			score[1] += A+B;
		return score;
	}
}