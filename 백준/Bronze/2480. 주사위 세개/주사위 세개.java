import java.io.*;
import java.util.*;

public class Main {
    public static int case1(int n) {
        return 10000 + n*1000;
    }

    public static int case2(int n) {
        return 1000 + n*100;
    }

    public static int case3(int n) {
        return n*100;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] n = new int[st.countTokens()];
        for (int i=0; i<3; i++)
            n[i] = Integer.parseInt(st.nextToken());

        int result;
        int max = n[0];
        if(n[0] == n[1]) {
            if(n[1] == n[2])
                result = case1(n[0]);
            else
                result = case2(n[1]);
        } else {
            if(n[1] == n[2])
                result = case2(n[1]);
            else if(n[0] == n[2])
                result = case2(n[0]);
            else {
                for (int i:n)
                    if(i>max)
                        max = i;
                result = case3(max);
            }
        }

        bw.write(Integer.toString(result));
        bw.close();
    }
}