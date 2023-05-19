package jiWoo.프로그래머스;

import java.util.*;
public class 프로그래머스_추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // photo의 크기
        int len = photo.length;
        int[] answer = new int[len];

        // 그리움 인물과 점수를 hashMap에 넣어주기
        // 사진을 볼 때 인물의 그리움 점수를 더해주기 위하여
        int size = name.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(name[i], yearning[i]);
        }

        // 사진에서 그리움 점수 구해주기
        for (int i = 0; i < len; i++) {
            for (String person : photo[i]) {
                // 사진 속의 사람이 map에 들어있다면 map에서 그리움 점수를 꺼내서 더해준다.
                if (map.containsKey(person)) {
                    answer[i] += map.get(person);
                }
            }
        }
        return answer;
    }
}
