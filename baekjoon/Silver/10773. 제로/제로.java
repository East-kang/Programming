import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());
        for (int i=0; i<K; i++) {
            int x = Integer.parseInt(br.readLine());
            switch (x) {
                case 0:
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(x);
                    break;
            }
        }

        int sum = 0;
        int size = stack.size();
        for (int i=0; i<size; i++) {
            sum += stack.pop();
        }
        bw.write(Integer.toString(sum));
        bw.close();
    }
}