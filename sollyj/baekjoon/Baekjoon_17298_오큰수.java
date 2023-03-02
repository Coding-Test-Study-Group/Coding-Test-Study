// Baekjoon_17298_오큰수
package sollyj.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_17298_오큰수 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        // A의 오큰수를 찾으려고 할때
        // A에 해당하는 index를 스택에 넣는다.
        // 오큰수를 찾았으면 그 index는 pop
        Stack<Integer> stack = new Stack<>();   
        int[] ans = new int[N]; // 정답을 넣을 배열

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0);  // 처음에는 스택이 비어있으므로 0을 넣어준다.
        for(int i=1; i<N; i++) {    // 오큰수를 찾기위해 오른쪽 값들을 순회
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);  
        }
        while(!stack.empty()) {
            ans[stack.pop()] = -1;
        }
        
        for(int i=0; i<N; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}