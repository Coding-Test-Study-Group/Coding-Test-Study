package jiWoo.백준;

import java.io.*;
import java.util.*;

public class 백준_12026번_BOJ거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 보도블록 N개
        // BOJ의 위치
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> O = new ArrayList<>();
        ArrayList<Integer> J = new ArrayList<>();
        char[] block = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            if (block[i] == 'B') {
                B.add(i);
                continue;
            } else if (block[i] == 'O') {
                O.add(i);
                continue;
            } else if (block[i] == 'J') {
                J.add(i);
                continue;
            }
        }
        // 점화식
        int D[] = new int[N];
        for (int i = 1; i < N; i++)
            D[i] = Integer.MAX_VALUE;
        D[0] = 0;
        for (int i = 0; i < N; i++) {
            char b = block[i];
            if (b == 'B') {// 다음 O로
                for (int idx : O) {
                    if (idx > i) { // 현재 B보다 더 뒤에 있는 O
                        if (D[i] != Integer.MAX_VALUE) { // 전에 점프한 경험 있을 때
                            D[idx] = Math.min(D[idx], D[i] + (int)Math.pow(idx-i,2));
                        }
                    }
                }
            }else if (b == 'O') {// 다음 J로
                for (int idx : J) {
                    if (idx > i) { // 현재 O보다 더 뒤에 있는 J
                        if (D[i] != Integer.MAX_VALUE) { // 전에 점프한 경험 있을 때
                            D[idx] = Math.min(D[idx], D[i] + (int)Math.pow(idx-i,2));
                        }
                    }
                }
            }else if (b == 'J') {// 다음 B로
                for (int idx : B) {
                    if (idx > i) { // 현재 J보다 더 뒤에 있는 B
                        if (D[i] != Integer.MAX_VALUE) { // 전에 점프한 경험 있을 때
                            D[idx] = Math.min(D[idx], D[i] + (int)Math.pow(idx-i,2));
                        }
                    }
                }
            }
        }

        if(D[N-1]!=Integer.MAX_VALUE){
            System.out.println(D[N-1]);
        }else System.out.println(-1);

    }
}
