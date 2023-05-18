package jiWoo.프로그래머스;

public class 프로그래머스_연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 10000001};

        int left = 0;
        int right = 0;
        int len = sequence.length;
        int value = sequence[0];

        // 투 포인터로 해결
        // 구간의 시작은 left, 끝은 right
        // left ~ right 사이의 값이 k이면 answer에 차이보다 작을 때 answer에 넣는다.
        // k를 찾아도 right를 뒤로 옮겨준다. (뒤에 더 작은 차이를 탐색해주기 위하여)
        // 주의할 점: left와 right의 index를 늘릴 때 배열의 길이보다 커지면 안된다.
        while (left <= right) {
            // 현재 구간의 값이 k 보다 작을 때는 right를 오른쪽으로 한 칸 옮겨준다.
            if (value < k) {
                // right가 끝이라면 더 이상 탐색할 것이 없으므로 종료해준다.
                if (right == len - 1) break;
                    // right가 이동할 수 있다면
                    // right의 값을 오른쪽으로 이동해주고 value 또한 오른쪽 값을 더해준다.
                else {
                    right++;
                    value += sequence[right];
                }
            }
            // 현재 구간의 값이 k보다 클 때 left를 오른쪽으로 한 칸 옮겨준다.
            else if (value > k) {
                // left가 끝이라면 더 이상 탐색할 것이 없으므로 종료
                if (left == len - 1) break;
                    // left가 오른쪽으로 이동할 수 있다면
                    // value 값에서 현재 left의 값을 빼주고
                    // left를 오른쪽으로 옮겨준다.
                else {
                    value -= sequence[left];
                    left ++;
                }

            }
            // 현재 구간의 값이 k라면 answer의 현재 값과 비교해서 answer를 찾아주고
            // 다른 값을 탐색하기 위하여 right를 오른쪽으로 옮겨준다.
            // 이때 left와 right가 끝이라면 종료
            else if (value == k) {
                if (right - left < answer[1] - answer[0]) {
                    answer = new int[]{left, right};
                }
                if (left == len -1 || right == len -1) break;

                right++;
                value += sequence[right];
            }
        }
        return answer;
    }
}
