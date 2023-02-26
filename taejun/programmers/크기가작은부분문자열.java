package taejun.programmers;

class Solution {
    public int solution(String t, String p) {
        
        int answer = 0;
        int len = p.length();
        long result = 0;
        long target = Long.parseLong(p);

        for(int i=0; i<t.length(); i++) {
            if(i+len <= t.length()) {
                result = Long.parseLong(t.substring(i, i+len));
                if(result <= target) answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }
}
