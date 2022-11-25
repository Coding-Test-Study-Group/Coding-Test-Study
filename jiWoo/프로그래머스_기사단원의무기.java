package jiWoo;

public class 프로그래머스_기사단원의무기 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            int divisor=findDivisor(i); // i기사의 약수=공격력
            
            if(divisor>limit){ // i 기사의 공격력이 제한보다 크면 공격력 power로 제한
                answer+=power;
            }else{ // 제한 이하이면 공격력 무기에 더함
                answer+=divisor;
            }
        }
        
        return answer;
    }
    // num의 약수를 구하는 메소드
    private static int findDivisor(int num){
        int result=1; // 자기 자신까지;
        if(num==1){
            return result;
        }else{
            for(int i=1;i<=num/2;i++){ // num의 반까지만 확인! (2로 나누면 반이므로)
                if(num%i== 0){
                    result++;
                }
            }
            return result;
        }
    }
}
