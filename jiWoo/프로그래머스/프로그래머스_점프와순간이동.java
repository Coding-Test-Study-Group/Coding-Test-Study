package jiWoo.프로그래머스;

public class 프로그래머스_점프와순간이동 {
        // 배수의 문제로 홀수는 전 짝수의 +1씩 늘리므로
        //2씩 나누며 홀수를 만났을 때의 count만 체크해준다. (count만큼 +1)
        public int solution(int n) {
            int ans = 1;
            int cnt=0; // +1되는 숫자
            while(n>2){
                if(n%2==1){ // n이 홀수면 +1해주기 위해 cnt++;
                    n-=1;
                    cnt++;
                }
                n/=2;
            }
            ans+=cnt;
            return ans;
        }

}
