package taejun.programmers;

import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {

        int answer = 0;
        int[] knights = new int[number];
        
        for(int i=0; i<number; i++) {
            knights[i] = i+1;
        }
        
        for(int i=0; i<knights.length; i++) {
            int atk = divisor(knights[i]);
            if(atk > limit) atk = power;
            answer += atk;
        }

        return answer;
    }

    public static int divisor(int n) {
        int cnt = 0;
        // n의 제곱근을 활용하여 보다 효율적으로 약수를 구하는 로직
        for(int i=1; i*i<=n; i++) {
            if(i * i == n) cnt++;
            else if(n % i == 0) cnt+=2;
        }
        return cnt;
    }
}
