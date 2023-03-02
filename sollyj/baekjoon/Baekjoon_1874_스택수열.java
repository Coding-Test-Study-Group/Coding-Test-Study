// Baekjoon_1874_스택수열

package sollyj.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1874_스택수열{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
         for(int i=0; i<n; i++) {
             arr[i] = Integer.parseInt(br.readLine());
        }
        boolean flag = true;
        StringBuffer bf = new StringBuffer();

        Stack<Integer> stack = new Stack<>();
        int i = 0;  // arr 인덱스
        int p = 1;  // 스택 push할 숫자 (오름차순))
        while(i < n) {
            if(p <= arr[i]){    // 현재 수열값보다 push할 값이 작거나 같으면
                while(p <= arr[i]) {    // 같아질때까지
                    stack.push(p);  // push 한다.
                    bf.append("+\n");
                    p++;
                }
                stack.pop();    // 같아지면 pop하고
                bf.append("-\n");
                i++;    // 다음 수열값
            } else {    // 현재 수열값보다 push할 값이 더 크면
                int pop = stack.pop();    // 계속 pop하다가
                
                if(pop > arr[i]){   // 스택의 top이 현재 수열값보다 크면 수열을 만들수없다.
                    System.out.println("NO");
                    flag = false;
                    break;
                }
                else {
                    bf.append("-\n");
                    i++;
                }
            }
        }
        if(flag)    System.out.println(bf.toString());
    }
}
