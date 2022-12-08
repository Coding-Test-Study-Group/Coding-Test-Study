package 삼총사;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] input1 = { -2, 3, 0, 2, -5 };
        int[] input2 = { -3, -2, -1, 0, 1, 2, 3 };
        int[] input3 = { -1, 1, -1, 1 };

        Solution s = new Solution();
        System.out.println(s.solution(input1));
        System.out.println(s.solution(input2));
        System.out.println(s.solution(input3));
    }
}

class Solution {
    public int solution(int[] number) {
        int answer = 0;

        // 모든 경우의 수를 탐색하는 완전탐색(brute force)
        // 주어진 number 배열의 길이가 최대 13 이라고 조건에 주어졌기때문에 완전탐색 알고리즘을 사용할 수 있었다.

        int len = number.length;

        // 첫번째 멤버(i)는 0번째부터 뒤에서 세번째까지
        for (int i = 0; i < len - 2; i++) {
            // 두번째 멤버(j)는 첫번째 멤버 바로 뒤에 있는 차례부터 뒤에서 두번째까지
            for (int j = i + 1; j < len - 1; j++) {
                // 세번째 멤버(k)는 두번째 멤버 바로 뒤에 있는 차례부터 맨 뒷자리까지 배열 탐색
                for (int k = j + 1; k < len; k++) {
                    // 모든 멤버 합이 0이면 삼총사의 조건에 만족하니까 answer에 1을 더해준다.
                    if (number[i] + number[j] + number[k] == 0)
                        answer++;
                }
            }
        }

        return answer;
    }
}