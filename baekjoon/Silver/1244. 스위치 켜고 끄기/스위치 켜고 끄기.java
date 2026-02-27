import java.io.*;
import java.util.*;

public class Main {
    public static int chage_state(int state) {
        return (state+1) % 2;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int sw_num = Integer.parseInt(br.readLine());
        int i, j;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sw_state = new int[sw_num+1];
        for(i=1; i<=sw_num; i++){
            sw_state[i] = Integer.parseInt(st.nextToken());
        }

        int student_num = Integer.parseInt(br.readLine());

        for(i=0; i<student_num; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            int left = index;
            int right = index;
            
            if(student == 1){
                for(j=index; j<=sw_num; j+=index){
                    sw_state[j] = chage_state(sw_state[j]);
                }
            } else if(student == 2) {
                while(left>0 && right<=sw_num){
                    if(sw_state[left] == sw_state[right]){
                        left--;
                        right++;
                    } else
                        break;
                }
                for(j=left+1; j<right; j++){
                    sw_state[j] = chage_state(sw_state[j]);
                }
            }
        }

        for(i=1; i<=sw_num; i++){
            bw.write(Integer.toString(sw_state[i]));
            if(i<sw_num && i%20 != 0)
                bw.write(" ");
            else
                bw.write("\n");
        }
        bw.close();
    }
}