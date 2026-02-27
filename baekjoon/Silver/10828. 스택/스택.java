/*
[명령]    [함수]
 push  : .push()
 pop   : .pop()
 size  : .size()
 empty : .isEmpty()
 top   : .peek()
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = st.countTokens();
            String str = st.nextToken();
            
            int x = 0;
            if (length == 2)
                x = Integer.parseInt(st.nextToken());
            
            switch (str) {
                case "push":
                    stack.push(x);
                    break;
                case "pop":
                    if (stack.isEmpty())
                        bw.write("-1");
                    else
                        bw.write(Integer.toString(stack.pop()));
                    break;
                case "size":
                    bw.write(Integer.toString(stack.size()));
                    break;
                case "empty":
                    if (stack.isEmpty())
                        bw.write("1");
                    else
                        bw.write("0");
                    break;
                case "top":
                    if (stack.isEmpty())
                        bw.write("-1");
                    else
                        bw.write(Integer.toString(stack.peek()));
                    break;
            }
            if (i<N-1 && (length != 2))
                bw.write("\n");
        }
        bw.close();
    }
}