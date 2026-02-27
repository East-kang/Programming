import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(M<45){
            M = (M+60)-45;
            H -= 1;
        } else 
            M -= 45;

        if(H<0)
            H += 24;

        bw.write(Integer.toString(H));
        bw.write(' ');
        bw.write(Integer.toString(M));
        bw.close();
    }
}