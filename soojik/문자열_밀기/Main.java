package 문자열_밀기;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("hello", "ohell"));
        System.out.println(s.solution("apple", "elppa"));
        System.out.println(s.solution("banana", "banana"));
    }
}

class Solution {
    public int solution(String A, String B) {
        int answer = 0;

        if (A.compareTo(B) == 0) return 0;

        int len = A.length();

        int cnt = 0;

        for (int i=0;i<len;i++) {
            cnt++;

            A = A.charAt(len-1) + A.substring(0, len-1);

            if (A.compareTo(B) == 0) {
                break;
            }
        }

        answer = (cnt == len) ? -1 : cnt;

        return answer;
    }
}