package 피자나눠먹기_3;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        
        System.out.println(s.solution(7, 10));   
    }
}

class Solution {
    public int solution(int slice, int n) {
        // n명이서 slice개 조각을 딱 나눠먹을 수 있으면 n/slice 판만 있으면 되지만, 딱 떨어지지 않는다면 한판이 더 필요하다.
        int answer = (n % slice == 0) ? n/slice : n/slice+1;
        return answer;
    }
}