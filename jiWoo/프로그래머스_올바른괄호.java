package jiWoo;
import java.util.*;
public class 프로그래머스_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> sk=new Stack<>();
        char [] carr=s.toCharArray();
        for(char c: carr){ // ( 이면 스택에 넣고 )이면 가장 최근 문자가 (여야 하고 뺀다
            if(c=='(') sk.add(c);
            else{
                if(sk.isEmpty() || sk.peek()!='('){
                    answer=false;
                    break;
                }
                sk.pop();
            }
        }
        // 다 비어지지 않았더라면 올바른 괄호 아님!
        if(!sk.isEmpty()) answer=false;
        return answer;
    }
}
