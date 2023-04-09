package jiWoo;
import java.util.*;
public class 프로그래머스_할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wanted = new HashMap<>();
        int len = want.length;
        // 해시에 원하는 물건과 index 넣기
        for (int i = 0; i < len; i++) {
            wanted.put(want[i], i);
        }
        int dLen = discount.length;
        // 확인할 데이터인지
        boolean check = false;
        // discount에 포함된 수량 체크
        int [] cnt = new int[len];
        // i번째부터 10개씩 확인해주기
        for (int i = 0; i <= dLen - 10; i++){
            cnt = new int[len];
            check = true;
            for (int j = i; j < i + 10; j++){
                // 현재 할인 물건이 내 위시리스트에 포함하지 않으면 확인 끝내기
                if (!wanted.containsKey(discount[j])){
                    check = false;
                    break;
                } else {
                    // 할인 물건의 내 위시리스트 인덱스
                    int idx = wanted.get(discount[j]);
                    // 수량 늘려주기
                    cnt[idx]++;
                    // 해당 물건의 수량이 내 위시리스트에서 원하는 수량보다 크면 일치하지 않으므로 탐색 종료
                    if(cnt[idx] > number[idx]) {
                        check = false;
                        break;
                    }
                }
            }
            // 위시리스트와 일치할 때 답 ++
            if(check) answer++;
        }
        return answer;
    }
}
