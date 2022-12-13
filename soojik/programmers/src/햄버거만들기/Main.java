package 햄버거만들기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(s.solution(new int[] {1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }
}

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        // 쌓인 재료 차례로 가져와 넣어놓을 list
        List<Integer> stacked = new ArrayList<>();
        
        int len = ingredient.length;

        // 주어진 재료 수만큼 배열 돌며
        for (int i=0;i<len;i++) {
            // 일단 stacked에 차례로 재료를 넣어놓고
            stacked.add(ingredient[i]);
            
            // 만약 재료가 4개 이상 쌓이고, 맨 마지막 재료가 1이라면
            int stacked_size = stacked.size();
            if (stacked_size >= 4 && stacked.get(stacked_size-1) == 1) {
                // 그 전의 재료가 차례대로 3, 2, 1 이 맞는지 계산한다.
                if (stacked.get(stacked_size-2) == 3 && stacked.get(stacked_size-3) == 2
                   && stacked.get(stacked_size-4) == 1) {
                    
                    // 맞다면 하나의 햄버거가 만들어졌으니까 answer에 1을 더해준다.
                    answer++;

                    // 쓰인 재료는 stacked에서 제거
                    for (int j=1;j<=4;j++) {
                        stacked.remove(stacked_size-j);
                    }
                }
            }
        }
        
        return answer;
    }
}