import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());
        int H = A;
        int M = B+C;
        if(M > 59) {
            H += (M/60);
            M %= 60;
            if (H > 23)
                H -= 24;
        }

        bw.write(Integer.toString(H) + ' ' + Integer.toString(M));
        bw.close();
    }
}