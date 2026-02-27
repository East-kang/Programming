import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(A+B) + "\n");
        bw.write(Integer.toString(A-B) + "\n");
        bw.write(Integer.toString(A*B) + "\n");
        bw.write(Integer.toString((int)((double)A/B)) + "\n");
        bw.write(Integer.toString(A%B));
        bw.close();
    }
}