package 콜라문제;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.solution(2, 1, 20));
        System.out.println(s.solution(3, 1, 20));
    }
}

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        // 빈병 a개를 가져갔을 때 b병의 콜라를 주는 마트
        // 빈병 n개를 가져다주면 몇 병을 받을 수 있는지

        // 가지고 있는 빈병(n개)이 a보다 작으면 더이상 교환 못하므로 그 이상인 경우만 반복
        while (n >= a) {
            // 답 출력할 변수에 갖고있는 병 개수 안에서 [빈병 a개 -> 콜라 b개] 최대로 교환할 수 있는 횟수는 n / a
            // 교환할 때마다 b병을 갖게되니까 b를 곱해 n / a * b 를 answer에 넣어준다.
            answer += (n / a * b);

            // n은 빈병 개수
            // n / a * a 는 한번 교환할 때 잃는 갖고있는 빈 병
            // n / a는 몫, 거기에 * a를 곱하는 것이니까 n과는 다른 결과가 나올 수 있다.
            // n / a * b 는 한번 교환할 때 갖는 콜라
            n -= n / a * a - n / a * b;
        }

        return answer;
    }
}