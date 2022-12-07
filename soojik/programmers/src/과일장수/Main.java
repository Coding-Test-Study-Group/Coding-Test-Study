package 과일장수;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] input1 = { 1, 2, 3, 1, 2, 3, 1 };
        System.out.println(s.solution(3, 4, input1));

        int[] input2 = { 4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2 };
        System.out.println(s.solution(4, 3, input2));
    }
}

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        // k는 최대 점수
        // m은 한 상자에 담기는 과일 수
        // score은 주어진 과일의 점수 배열

        // score 배열 길이
        int len = score.length;

        // 배열 Integer로 복사해서
        Integer[] sorted_score = new Integer[len];
        for (int i = 0; i < len; i++)
            sorted_score[i] = score[i];

        // Arrays.sort 함수로 정렬
        Arrays.sort(sorted_score, Collections.reverseOrder());

        // 이미 sorted_score 배열에 큰 점수부터 내림차순 정렬되어있기 때문에
        // m씩 잘라서 바구니에 넣는다고 하면 m-1부터 m씩 더하는 인덱스 자리에 각 바구니의 최솟값이 있을것이다.
        // 따라서 배열 시작점은 m-1, i의 값이 len을 넘지않는 것을 확인 후 answer에 최소값 더해주고, m을 더해 다음 바구니의 최소값 구한다.
        for (int i=m-1;i<len;i+=m) {
            answer += sorted_score[i];
        }

        // 각 바구니의 최소값을 다 더한 answer에 m을 곱해주면 답
        return answer * m;
    }
}