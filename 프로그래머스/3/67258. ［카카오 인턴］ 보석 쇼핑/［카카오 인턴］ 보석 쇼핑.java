import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalType = gemTypes.size();

        Map<String, Integer> map = new HashMap<>();

        int left = 0;
        int minLen = gems.length + 1;

        int[] answer = new int[2];

        for (int right = 0; right < gems.length; right++) {
            String rightGem = gems[right];
            map.put(rightGem, map.getOrDefault(rightGem, 0) + 1);

            while (map.size() == totalType) {
                int len = right - left + 1;

                if (len < minLen) {
                    minLen = len;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }

                String leftGem = gems[left];
                map.put(leftGem, map.get(leftGem) - 1);

                if (map.get(leftGem) == 0) {
                    map.remove(leftGem);
                }

                left++;
            }
        }

        return answer;
    }
}