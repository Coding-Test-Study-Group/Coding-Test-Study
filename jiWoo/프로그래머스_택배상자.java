package jiWoo;
import java.util.*;
public class 프로그래머스_택배상자 {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> temp=new Stack<>();
        Stack<Integer> main=new Stack<>();
        int len=order.length;
        // 전부 넣어주기 순서대로!
        for(int i=len; i>0; i--){
            main.add(i);
        }
        int index=0;
        loop:
        for(int i=0; i<len; i++){
            if(main.contains(order[i])){
                boolean find=false;
                while(!find){
                    int now=main.pop();
                    if(now==order[i]){
                        answer++;
                        continue loop;
                    }
                    else temp.add(now);
                }
            }else if(temp.peek()==order[i]){
                answer++;
                temp.pop();
                continue;
            }
            break;
        }
        return answer;
    }
}
