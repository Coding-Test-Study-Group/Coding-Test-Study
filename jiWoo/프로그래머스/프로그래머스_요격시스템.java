package jiWoo.프로그래머스;
import java.util.*;
public class 프로그래머스_요격시스템 {
        public int solution(int[][] targets) {
            int answer = 0;
            //  (s, e)에서 끝나는 지점 e를 기준으로 오름차순 정렬
            Arrays.sort(targets, (o1 ,o2) -> {
                return o1[1] - o2[1];
            });

            // target의 개수
            int cnt = targets.length;
            // 격추 여부
            boolean[] checked = new boolean[cnt];

            for (int i = 0; i < cnt; i++) {
                // 요격 미사일 개수 ++
                answer++;
                // 현재 target 미사일의 끝나는 지점
                int point = targets[i][1];
                // 격추한 미사일 개수(기준으로 삼는 i(미사일) 크기 늘려주기 위하여)
                int killed = 0;
                // 다음 target 미사일의 시작 지점이 끝나는 지점보다 작으면 격추
                // else 크거나 같으면 반복문 종료(오름차순 정렬로 다음 미사일은 더 뒤에 있으므로 확인할 필요 X)
                for (int j = i + 1; j < cnt; j++) {
                    if (targets[j][0] < point) {
                        killed++;
                    } else break;
                }

                // 격추한 수만큼 i 늘려주기
                i += killed;
            }

            return answer;
        }
}
