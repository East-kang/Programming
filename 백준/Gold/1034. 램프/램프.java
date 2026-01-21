import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int K = Integer.parseInt(br.readLine());

        int max = 0;
        for (String key : map.keySet()) {
            int zero = 0;
            for (int i = 0; i < M; i++) {
                if (key.charAt(i) == '0') {
                    zero++;
                }
            }

            if (zero <= K && (K - zero) % 2 == 0) {
                max = Math.max(max, map.get(key));
            }
        }

        System.out.println(max);
    }
}