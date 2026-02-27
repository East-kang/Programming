import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter br2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br1.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        br2.write(Integer.toString(A+B));
        br2.flush();
    }
}