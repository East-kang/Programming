import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Boolean> map = new HashMap<>();
        
        for(String phone : phone_book) {
            String str = "";
            int n = phone.length();
            
            for(int i=0; i<n; i++) {
                str += phone.charAt(i);
                if(i == n-1 && map.containsKey(str))     return false;
                if(map.containsKey(str) && map.get(str)) return false;
                
                if(i<n-1)   map.put(str, false);
                else        map.put(str, true);
            }
        }
        return true;
    }
}