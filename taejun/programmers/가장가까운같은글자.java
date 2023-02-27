package taejun.programmers;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int[] answer = new int[s.length()];
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            String str = Character.toString(s.charAt(i));
            if(hm.get(str) == null) {
                hm.put(str, i);
                answer[i] = -1;
            }
            else {
                answer[i] = i - hm.get(str);
                hm.put(str, i);
            }
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}