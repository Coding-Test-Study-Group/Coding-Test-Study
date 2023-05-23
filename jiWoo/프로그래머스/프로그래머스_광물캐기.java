package jiWoo.프로그래머스;
import java.util.*;
public class 프로그래머스_광물캐기 {
    static ArrayList<String> stress = new ArrayList<>(Arrays.asList("diamond", "iron", "stone"));
    static int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {

        DFS(picks, minerals, 0, 0);
        return answer;
    }

    private static void DFS(int[] picks, String[] minerals, int idx, int result) {
        int len = minerals.length;
        int re = 0;
        // 사용할 수 있는 광물이 없을 때 결과 출력!
        if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            answer = Math.min(answer,result);
            return;
        }

        // 현재 광물을 3개중에 선택
        for (int i = 0; i < 3; i++) {
            // result에 피로도를 더해줄 것인데 광물 3개를 비교해줄것이기 때문에 임시 re
            re = result;
            // 현재 사용할 광물이 있더라면
            if (picks[i] > 0) {
                // 광물 하나당 5개를 캘 수 있으므로
                for (int j = 0; j < 5; j++) {
                    // 현재 광물이 캘 5개가 캘 광물의 크기를 넘지 않는다면
                    // 피로도에 더해준다.
                    if (idx + j < len) {
                        // 피로도는 5의 제곱을 사용하여 계산식을 만들어 구함
                        // 곡괭이는 다이아몬드, 철, 돌 순으로 0, 1, 2 인덱스이고
                        // 현재 광물도 다이아몬드, 철, 돌 순인데
                        // 곡괭이의 인덱스가 더 크다면 5의 (곡괭이 인덱스 - 광물 인덱스)의 제곱으로
                        // 인덱스가 작으면 ++로 1만 더해줌
                        int findIdx = stress.indexOf(minerals[idx + j]);
                        if (i >= findIdx) re += Math.pow(5, i - findIdx);
                        else re++;
                    } else {
                        // 인덱스가
                        answer = Math.min(answer,re);
                        return;
                    }
                }
                // 사용할 광물을 빼주고 재귀로 DFS 사용
                picks[i]--;
                DFS(picks, minerals, idx + 5, re);
                // 다시 광물 더해준다.
                picks[i]++;
            }
        }
    }
}
