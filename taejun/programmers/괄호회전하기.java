package taejun.programmers;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++) {
            String rotate = s.substring(i, s.length()) + s.substring(0, i);
            if(isBracket(rotate)) answer++;
        }
        return answer;
    }
    public static boolean isBracket(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            switch (c) {
                case '(': case '{': case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
