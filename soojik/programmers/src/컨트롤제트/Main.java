package 컨트롤제트;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("1 2 Z 3"));
        System.out.println(s.solution("10 20 30 40"));
        System.out.println(s.solution("10 Z 20 Z 1"));
        System.out.println(s.solution("10 Z 20 Z"));
    }
}

class Solution {
    public int solution(String s) {
        int answer = 0;

        // 주어진 문자열을 공백 기준으로 나눠 String 배열 str에 저장
        String[] str = s.split(" ");

        // str 배열의 크기만큼 순회하며 해당 위치(i)의 원소가 Z라면 바로 전에 더했던 숫자를 다시 빼준다.
        // Z가 첫번째에 오지 않는다는 제한이 있었기에 인덱스 [i-1]에 접근해도 무방
        int len = str.length;
        for (int i = 0; i < len; i++) {
            if (str[i].equals("Z")) {
                answer -= Integer.parseInt(str[i - 1]);
            } else {
                answer += Integer.parseInt(str[i]);
            }
        }

        return answer;
    }
}