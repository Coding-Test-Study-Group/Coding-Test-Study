package 문자열_나누기;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.solution("banana"));
        System.out.println(s.solution("abracadabra"));
        System.out.println(s.solution("aaabbaccccabba"));
    }
}

class Solution {
    public int solution(String s) {
        int answer = 0;

        int len = s.length();

        // 같은 문자나 처음 나온 문자는 same에, 다른 문자 diff에 count
        int same = 0, diff = 0;

        // 처음 나온 문자 보관할 x
        char x = ' ';

        for (int i = 0; i < len; i++) {
            // 첫 인덱스이거나 직전에 문자열이 나눠져 x가 공백 값이라면
            if (x == ' ') {
                // 현재 위치의 문자를 시작점, 기준으로 잡고
                x = s.charAt(i);
                // same에 값 더해준다.
                same++;

            // 이미 기준 문자가 있다면
            } else {

                // 현재 문자와 비교해서 같다면 same에, 다르면 diff에 +1
                if (x == s.charAt(i)) {
                    same++;
                } else {
                    diff++;
                }

                // 현재 위치 문자까지 비교한 후
                // same과 diff의 값이 같다면 뒤에 이어지는 새로운 문자열 나누기를 위해 기준 문자 x에 다시 공백 값을 넣어주고
                // 하나의 문자열이 분리되었으므로 answer에 +1
                if (same == diff) {
                    x = ' ';
                    answer++;
                }
            }

        }

        // 탐색이 끝난 후, x에 값이 있다면 이 또한 문자열이기 때문에 answer에 +1
        if (x != ' ')
            answer++;

        return answer;
    }
}