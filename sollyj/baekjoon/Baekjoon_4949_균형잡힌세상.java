// Baekjoon_4949_균형잡힌세상
package sollyj.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_4949_균형잡힌세상 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bf = new StringBuffer("");

        int small_open = 0, large_open = 1;

        while(true) {
            boolean flag = true;
            Stack<Integer> stack = new Stack<>();

            String st = br.readLine();
            if(st.equals("."))   break;

            int len = st.length();
        
            for(int i=0; i<len-1; i++) {
                // 괄호 처리
                if(st.charAt(i) == '(') {
                    stack.push(small_open);
                } else if(st.charAt(i) == '[') {
                    stack.push(large_open);
                } else if(st.charAt(i) == ')') {
                    if(stack.isEmpty() || stack.peek() == 1) {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if(st.charAt(i) == ']') {
                    if(stack.isEmpty() || stack.peek() == 0) {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            // 문자열을 다 돌고도 stack에 남아있다는 것은 괄호가 안 닫혔다는 뜻
            if(!stack.empty())  {
                flag = false;  
            }
            
            if(flag)    bf.append("yes\n");
            else        bf.append("no\n");
        }

        System.out.print(bf.toString());
    }
}
