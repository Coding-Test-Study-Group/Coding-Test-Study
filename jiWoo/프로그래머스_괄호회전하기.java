package jiWoo;
import java.util.*;
public class 프로그래머스_괄호회전하기 {
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length(); i++){
            char now=s.charAt(0); // s의 첫 문자
            s=s.substring(1)+now; // 뒤로 붙여주기
            if(ok(s)){
                answer++;
            }
        }
        return answer;
    }
    // 올바른 괄호 문자열인 지 확인, 스택에 괄호를 열려있는 괄호는 넣고 닫는 괄호면 스택 맨 위에 있는 것이 같은 괄호면 pop해서 스택이 비어있으면 올바른 괄호
    public static boolean ok(String s){
        Stack<Character> sk=new Stack<>();
        char[] arr=s.toCharArray();
        for(char c:arr){
            if(c=='[' || c=='(' || c=='{'){ // 열려있는 괄호면 넣어준다.
                sk.add(c);
            }else if(!sk.isEmpty()){ // 비어있지않고 현재가 닫는 괄호면 빼주거나 넣어주거나
                if(c==']' && sk.peek()=='['){
                    sk.pop();
                }else if(c==')' && sk.peek()=='('){
                    sk.pop();
                }else if(c=='}' && sk.peek()=='{'){
                    sk.pop();
                }else{
                    sk.add(c);
                }
            }else{
                sk.add(c);
            }
        }
        return sk.isEmpty();
    }
}
