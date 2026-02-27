import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());

        int count = 0;
        while(A<K){
            if(K%2 == 0 && K/2 >= A) K /= 2;
            else         K -= 1;
            count++;
        }
        
        bw.write(Integer.toString(count));
        bw.close();
    }
}