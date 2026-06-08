import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++) {
            int t = Integer.parseInt(br.readLine());
            int v = 0, d = 0;
            for(int i=0; i<t; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                if(cmd == 0) { d += v; continue; }
                
                int a = Integer.parseInt(st.nextToken());
                if(cmd == 1) { v += a; }
                else { v = (v-a < 0 ? 0 : v-a); }
                d += v;
            }
            System.out.println("#"+tc+" "+d);
		}
	}
}