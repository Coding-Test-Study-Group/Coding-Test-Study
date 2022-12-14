package jiWoo;

import java.util.Scanner;

public class 백준_1780번_종이의개수 {
    static int[][] paper;
    static int[] result = { 0, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        paper = new int[N][N]; // 종이

        for (int i = 0; i < N; i++) { //종이 배열 받아주기 
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        // 처음에 확인해주기
        int num = paper[0][0];
        boolean same = sameNumPaper(N,num, 0, 0); // 같은 숫자로 이루어져 있는지
        if (same) { // 같은 숫자면 값에 +1;
            result[num + 1]++;
        } else {// 아니면 종이 잘라준다
            CutPaper(N, 0, 0);
        }
        // 정답 출력
        for (int r : result) 
            System.out.println(r);
    }

    private static void CutPaper(int size, int sr, int sc) {
        // size가 1이면 종이 1장이므로 그냥 각각 값에 더해준다

        int nextSize = size / 3; // 잘라진 종이의 크기
        for (int i = sr; i < sr + size; i += nextSize) {
            for (int j = sc; j < sc + size; j += nextSize) {
                if (nextSize == 1) { // 9분할을 했을 때 종이의 크기가 1이라면 그냥 결과 값에 넣어준다!
                    result[paper[i][j] + 1]++;
                } else { // 9분할을 했을 때 종이의 크기가 3이상이라면
                    int num = paper[i][j]; // 우리가 확인할 수
                    boolean same = sameNumPaper(nextSize,num, i, j); // 현재 잘라진 종이에 num으로만 있는지 확인
                    if (same) { // 같은 숫자로 이루어지면 값에 +1
                        result[num + 1]++;
                        continue;
                    } else { // 같은 숫자로 이루어지지 않았으면 다시 잘라준다.
                        CutPaper(nextSize, i, j); // 이 부분 다시 잘라죠!
                    }
                }
            }
        }

    }

    private static boolean sameNumPaper(int size, int num, int r, int c) { // 현재 잘라진 종이에 num만 있으면 true 아니면 false
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (paper[i][j] != num)
                    return false; // 같은 숫자로 이루어진 종이가 아니다
            }
        }
        return true;// 같은 숫자로 이루어진 종이다.
    }
}
