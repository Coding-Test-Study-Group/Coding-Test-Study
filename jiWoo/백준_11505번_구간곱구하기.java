
import java.util.*;

public class 백준_11505번_구간곱구하기 {
    static long[] tree;
    static long Mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N: 수의 개수, M: 변경 횟수, K: 구간의 곱 구하는 횟수
        int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
        // 트리의 크기 구하기
        int size = 0;
        while (true) {
            if (Math.pow(2, size) >= N) {
                break;
            }
            size++;
        }
        // 트리에 수 넣기
        tree = new long[(int) Math.pow(2, size + 1)];
        int startidx = (int) Math.pow(2, size);
        // 곱을 위해
        for (int i = 0; i < tree.length; i++) {
            tree[i] = 1;
        }
        for (int i = 0; i < N; i++) {
            tree[startidx + i] = sc.nextLong();
        }
        // 트리의 곱으로 트리 set하기
        setMultiTree((int) Math.pow(2, size + 1) - 1);
        // 변경 or 곱 구하기
        for (int i = 0; i < M + K; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            long c = sc.nextLong();
            if (a == 1) { // a가 1이면 b번째를 c로 변경
                changeTree(startidx + b - 1, c);
            } else if (a == 2) { // a가 2이면 b~c 까지의 곱을 구한다
                System.out.println(findMulti(startidx + b - 1, (int) (startidx + c - 1)));
            }
        }

    }

    private static void setMultiTree(int idx) {
        while (idx > 1) { // 루트노드 전까지
            tree[idx / 2] = tree[idx / 2] * tree[idx] % Mod;
            idx--;
        }
    }

    private static void changeTree(int idx, long now) {
        tree[idx] = now;
        while (idx > 1) {
            idx = idx / 2;// 부모노드로 이동하여 현재 자식노드 곱해주기
            tree[idx] = tree[idx * 2] % Mod * tree[idx * 2 + 1] % Mod;
        }

    }

    private static long findMulti(int start, int end) {
        long result = 1;
        while (start <= end) {
            if (start % 2 == 1) {
                result = result * tree[start] % Mod;
                start++;
            }
            if (end % 2 == 0) {
                result = result * tree[end] % Mod;
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return result;
    }

}