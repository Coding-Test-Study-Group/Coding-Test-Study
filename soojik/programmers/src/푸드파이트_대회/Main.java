package 푸드파이트_대회;

public class Main {
    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        Solution s = new Solution();

        System.out.println(s.solution(food));

        int[] food2 = {1, 7, 1, 2};
        System.out.println(s.solution(food2));
    }
}

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        // 주어진 음식 개수
        int len = food.length;

        // 음식 개수 배열 돌며
        for (int i=1;i<len;i++) {
            // i번째 음식 개수를 cnt_food에 넣고,
            int cnt_food = food[i];

            // 두 명이서 나눠야하니까 2로 나눠준다.
            cnt_food /= 2;

            // 2로 나눠준 개수만큼 정답 만들 문자열 sb에 넣어준다.
            for (int j=0;j<cnt_food;j++) {
                sb.append(i);
            }
        }

        // 모든 음식 개수를 2로 나눴으므로, 한 사람당 먹어야하는 개수 == sb.length()
        // 이 개수를 foods_len 변수에 저장한다.
        int foods_len = sb.length();

        // 중간에 목표인 물, 0이 있어야하니 넣어준다.
        sb.append(0);

        // 처음 1번 선수가 왼->오 방향으로 먹어야하는 음식을 저장한 sb 배열을 0을 제외해 거꾸로 돌며 sb에 저장한다.
        for (int i=foods_len-1;i>=0;i--) {
            sb.append(sb.charAt(i));
        }
        
        return sb.toString();
    }
}