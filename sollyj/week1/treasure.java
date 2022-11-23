//backjoon 1026
import java.util.*;

public class treasure {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        int result_min = 0;    // 출력값

        for(int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        for(int i = 0; i < n; i++) {
            b[i] = scan.nextInt();
        }

        // 각 배열 오름차순 정렬해서
        Arrays.sort(a);
        Arrays.sort(b);

        // 거꾸로 곱해서 더해주면 최솟값
        for(int i = 0; i < n; i++) {
            result_min += a[i] * b[n-i-1];
        }

        System.out.println(result_min);
    }
}
