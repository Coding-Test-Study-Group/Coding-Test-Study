package jiWoo.백준;
import java.util.*;
public class 백준_방번호 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String room_number = sc.nextLine();
        int len = room_number.length();
        // Hashmap으로 세트 숫자 개수 처리
        // 남아있는 개수: 숫자의 개수
        HashMap<Integer, Integer> map = new HashMap<>();
        // Map 초기화
        for (int i = 0; i < 10; i++) {
            map.put(i, 1);
        }
       // 세트 사용 개수
        int answer = 1;
        for (int i = 0; i < len; i++) {
            int num = Integer.parseInt(String.valueOf(room_number.charAt(i)));
            int numCnt = map.get(num);
            // 해당 숫자의 개수 있을 때, 개수 사용
            if (numCnt > 0) {
                map.put(num, numCnt - 1);
            }
            // 해당 숫자가 6인데 6은 없고 9는 있을 때
            // 9도 마찬가지
            else if (num == 6 && map.get(9) > 0) {
                map.put(9, map.get(9) - 1);
            }
            else if (num == 9 && map.get(6) > 0) {
                map.put(6, map.get(6) - 1);
            }
            // 그 외 해당 숫자가 없을 때
            // 세트 추가
            else if (numCnt == 0) {
                plusSet(map);
                map.put(num, map.get(num) - 1);
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void plusSet (HashMap<Integer, Integer> map) {
        for (int i = 0; i < 10; i++) {
            int num = map.get(i);
            map.put(i, num + 1);
        }
    }
}
