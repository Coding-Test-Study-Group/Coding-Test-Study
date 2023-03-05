package jiWoo;
import java.util.*;
public class 프로그래머스_소수찾기 {
    static boolean[] checked=new boolean[7]; // 사용한 숫자인지 체크
    static ArrayList<Integer> arr=new ArrayList<>(); // 만든 소수 리스트
    static int answer=0;
    public int solution(String numbers) {
        for(int i=0; i<numbers.length(); i++){
            // numbers의 길이만큼 숫자가 만들어질 수 있으므로 1~ 길이만큼의 숫자들을 확인해주기 위하여
            dfs(numbers,"",i+1);
        }

        return answer;
    }
    public void dfs(String num, String now, int len){
        if(now.length()==len){
            int n=Integer.parseInt(now); // 확인할 숫자
            if(isPrime(n) && !arr.contains(n)){ // n이 소수이고 전에 확인했던 숫자가 아닐 때
                arr.add(n); // 소수 리스트에 넣어주기
                answer++;
            }
        }else{
            for(int i=0; i<num.length(); i++){
                if(!checked[i]){// 사용한 숫자인지 확인
                    checked[i]=true;
                    dfs(num,now+num.charAt(i),len);  // 하나씩 붙여서 확인해줌
                    checked[i]=false;
                }
            }
        }
    }
    public boolean isPrime(int num){
        if(num ==0 || num==1){
            return false;
        }else{
            for(int i=2; i<num; i++){
                if(num%i==0) return false;
            }
            return true;
        }
    }
}
