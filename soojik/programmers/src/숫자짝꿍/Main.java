package 숫자짝꿍;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("100", "2345"));
        System.out.println(s.solution("100", "203045"));
        System.out.println(s.solution("100", "123450"));
        System.out.println(s.solution("42531", "12321"));
        System.out.println(s.solution("5525", "1255"));
        System.out.println(s.solution("0", "0"));
        System.out.println(s.solution("22", "22"));
    }
}

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        int len_x = X.length();
        int len_y = Y.length();

        // X, Y 문자열 탐색하며 0 ~ 9가 나오는 횟수 담을 count 배열
        int[] count_num_x = new int[10];
        int[] count_num_y = new int[10];

        // 배열 처음부터 끝까지 돌면서 count 배열에 자릿값의 정수값(X.charAt(i)-'0') 자리에 +1 씩 더해줌
        for (int i = 0; i < len_x; i++) {
            count_num_x[X.charAt(i) - '0']++;
        }

        for (int i = 0; i < len_y; i++) {
            count_num_y[Y.charAt(i) - '0']++;
        }

        // 0 ~ 9 숫자 출현한 횟수 담은 count 배열 돌아, 두 문자열 모두에서 나온 모든 숫자 넣어줄 list 리스트
        List<String> list = new ArrayList<>();

        int cnt_x, cnt_y;
        for (int i = 0; i < 10; i++) {
            cnt_x = count_num_x[i];
            cnt_y = count_num_y[i];
            // count 배열에서 해당 숫자(i)가 X, Y 모두에서 0번 이상 나왔다면
            if (cnt_x > 0 && cnt_y > 0) {
                // 둘 중 작게 출현한 횟수 min에 담고
                int min = Math.min(cnt_x, cnt_y);
                // min 횟수만큼 list에 숫자(i) 넣어준다.
                for (int j = 0; j < min; j++) {
                    list.add(Integer.toString(i));
                }
            }
        }

        // 만약 list에 아무것도 담지 못했다면 공통 숫자가 없다는 뜻이므로 -1 출력
        if (list.size() == 0)
            return "-1";

        // list에 있는 숫자 내림차순 정렬
        list.sort(Comparator.reverseOrder());

        // 역순으로 정렬된 숫자 answer에 삽입
        for (String i : list) {
            answer.append(i);
        }

        // 모든 숫자 담은 answer가 0으로 시작한다면 그건 0이 제일 큰 숫자, 그 뒤엔 계속 0이라는 뜻이므로 0 return
        if (answer.charAt(0) - '0' == 0) {
            return "0";
        }

        return answer.toString();
    }
}