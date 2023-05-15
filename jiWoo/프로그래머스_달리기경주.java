package jiWoo;
import java.util.*;
public class 프로그래머스_달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        int len = players.length;
        String[] answer = new String[len];
        // 플레이어의 현재 등수(index) 값 저장
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(players[i], i);
        }

        // 불릴때마다 player의 순서를 바꿔주고 map의 index 값도 바꿔준다.
        for (String call : callings) {
            int nowIdx = map.get(call);
            map.put(players[nowIdx - 1], nowIdx);
            map.put(call, nowIdx - 1);
            players[nowIdx] = players[nowIdx - 1];
            players[nowIdx - 1] = call;
        }

        // answer 출력
        answer = players;
        return answer;
    }
}
