// Baekjoon_11899_괄호
package sollyj.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11899_괄호 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();   // 괄호 넣을 스택

        int open = 0;
        int count = 0;

        String st = br.readLine();
        for(short i=0; i<st.length(); i++) {
            if(st.charAt(i) == '(')   stack.push(open); // (나오면 push
            else if(st.charAt(i) == ')') {  
                if(stack.empty())   count++;    // )인데 스택이 비었다는것은 (가 한번도 안나왔다는 것을 의미하므로 count++
                else    stack.pop();    // 스택이 안비었다면 (가 있다는 의미이므로 pop
            }
        }
        if(!stack.empty())  {
            count = count + stack.size();   // 문자열을 다 돌고도 stack에 남아있다는 것은 (에 대한 )가 부족하다는 것을 의미하므로 stack사이즈만큼 count++
        }
        System.out.println(count);
    }
}