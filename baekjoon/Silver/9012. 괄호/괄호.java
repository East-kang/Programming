import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            String str = br.readLine();
            Stack<Character> s = new Stack<>();
            boolean isRight = true;
            for (char c : str.toCharArray()) {
                if (c == '(')
                    s.push('(');
                else {
                    if (s.isEmpty()) {
                        bw.write("NO\n");
                        isRight = false;
                        break;
                    } else {
                        s.pop();
                    }   
                }
            }
            if (!s.isEmpty()) {
                bw.write("NO\n");
            } else if (isRight) {
                bw.write("YES\n");
            }
        }
        bw.close();
    }
}