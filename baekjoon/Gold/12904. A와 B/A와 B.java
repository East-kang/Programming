import java.util.*;
import java.io.*;

class Main {
    public static int recursive(String s, String t) {
        if(s.equals(t))
            return 1;

        if(t == "")
            return 0;
        int tn = t.length();
        if(s.length() > tn)
            return 0;

        if(t.charAt(tn-1) == 'A'){
            return recursive(s, t.substring(0, tn-1));
        } else {
            String tmp = new StringBuilder(t.substring(0, tn-1)).reverse().toString();
            return recursive(s, tmp);
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        String T = br.readLine();

        if(recursive(S, T) == 0)
            bw.write("0");
        else
            bw.write("1");
        bw.close();
    }
}