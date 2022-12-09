package 가장_가까운_같은_글자;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        print_answer(s.solution("banana"));
        print_answer(s.solution("foobar"));
    }

    static void print_answer(int[] answer) {
        for (int a : answer) {
            System.out.print(a + " ");
        }

        System.out.println();
    }
}

class Solution {
    public int[] solution(String s) {
        int len = s.length();

        // 주어진 문자열 s 길이 만큼의 정답 출력을 위한 answer 배열 생성
        int[] answer = new int[len];

        // 각 알파벳마다 가장 최근 출현했던 인덱스 기록하기 위해 26 크기 만큼의 alpha 배열 생성
        int[] alpha = new int[26];
        
        // 최근 출현 인덱스가 0일 수 있기 때문에 -1로 초기화
        // 알파벳 숫자만큼 배열을 돌며 -1로 초기화
        for (int i = 0; i < 26; i++)
            alpha[i] = -1;

        // last_alpha_idx는 현재 위치의 문자가 a로부터 몇번째 알파벳인지, alpha의 인덱스로서 쓰일 값
        // last_alpha는 현재 위치의 문자가 가장 최근 출현했던 인덱스값
        int last_alpha_idx, last_alpha;

        for (int i = 0; i < len; i++) {

            // 현재 알파벳 s.charAt(i) 에서 'a'를 빼줌으로써 alpha배열의 인덱스값으로 사용할 수 있다.
            last_alpha_idx = s.charAt(i) - 'a';
            // alpha 배열에서 현재 위치 문자(last_alpha_idx)가 가장 최근 출현했던 위치 가져온다.
            last_alpha = alpha[last_alpha_idx];

            // 만약 가장 최근 출현했던 곳이 있다면 값은 0 이상일 것
            if (last_alpha >= 0)

                // 떨어진 값을 구해야하므로, 현재 위치에서 마지막 출현 위치를 뺀 값을 답 배열에 삽입
                answer[i] = i - last_alpha;
            else
                // 만약 -1, 음수값이라면 -1 대입
                answer[i] = -1;

            // 그리고 현재 위치의 문자를 가장 최근 출현한 인덱스로 업데이트 해준다.
            alpha[last_alpha_idx] = i;
        }

        return answer;
    }
}