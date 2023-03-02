// Baekjoon_2023_신기한소수
package sollyj.baekjoon;

import java.io.*;

public class Baekjoon_2023_신기한소수 {
    public static short N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Short.parseShort(br.readLine());

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    // 현재숫자가 소수인지 판별하면서 자리수를 N까지 늘려가면서 깊이우선탐색을 하는 함수
    private static void DFS(int num, int len) {   // 현재숫자, 자리수
        if(len == (int)N) {
            if(isPrime(num))   System.out.println(num);
            return;
        }

        for(int i=1; i<=9; i++) {
            if(isPrime(num*10+i))
                DFS(num*10+i, len+1);
        }
    }

    // 소수 판별 메서드
    private static boolean isPrime(int num) {
        if(num <= 1)    return false;

        for(int i=2; i<num; i++) {
            if(num % i == 0) 
                return false;
        }
        return true;
    }
}
