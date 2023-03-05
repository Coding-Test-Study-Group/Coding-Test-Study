package jiWoo;

public class 프로그래머스_카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int x=3; // x는 세로 값 y를 가로 값으로 했을 때 2y+2x-4= brown, (x-2))y-2)=yellow로 식을 구해서 다 돌려서 탐색함!
            int val=brown+yellow;
            int[] answer=new int[2];
            while(true){
                if(val%x==0 && val/x>=x && (2*x+2*(val/x)-4)==brown){
                    answer[1]=x;
                    answer[0]=val/x;
                    break;
                }
                x++;
            }
            return answer;
        }
    }
}
