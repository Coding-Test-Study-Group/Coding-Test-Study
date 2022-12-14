package 기사단원의_무기;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 1부터 number번까지 순회
        for (int i=1;i<=number;i++) {
            // i의 약수 개수를 구해 div 참조
            int div = countDiv(i);
            
            // 만약 약수의 개수 div가 limit 값을 넘는다면 정해진 power을 answer에 더해주고, 아니면 약수 개수 div 그대로 더해준다.
            answer += (div > limit) ? power : div;
        }
        
        return answer;
    }
    
    // 약수 개수 구하는 메서드
    public int countDiv(int n) {
        int result = 0;
        
        // 약수 개수를 구할 정수 n의 제곱근 값을 tmp에 참조
        int tmp = (int)Math.sqrt(n);

        // 1부터 tmp까지 순회하며
        for (int i=1;i<=tmp;i++) {
            // 만약 n이 i로 나누어 떨어진다면 result에 1 증가
            if (n % i == 0) {
                result++;

                // 그리고 n에 i를 나눈 나머지와 i가 같지 않다면
                // 즉, i*i가 n이 아닐 경우에 i와 함께 곱해져 n이 되는 다른 약수가 있다는 뜻이므로 result에 1 증가
                if (i != n/i) {
                    result++;
                }
            }
        }
        
        return result;
    }
}