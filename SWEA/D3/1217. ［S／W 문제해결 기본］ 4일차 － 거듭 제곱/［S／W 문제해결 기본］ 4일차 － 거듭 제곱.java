import java.util.Scanner;
class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        
		for(int tc=1; tc<=10; tc++) {
			int T = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println("#"+tc+" "+recursive(n, m));
		}
	}
    
    public static int recursive(int n, int m) {
		if(m == 0)	return 1;
        return n * recursive(n, m-1);
    }
}