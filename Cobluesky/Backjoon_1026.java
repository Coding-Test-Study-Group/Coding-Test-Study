import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N]; // 배열의 크기를 받습니다.
        st = new StringTokenizer(br.readLine()); // bufferedReader의 값 가공을 위해 StringTokenizer를 만듭니다.

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken()); // 배열에 값을 집어넣습니다.
        }
        Arrays.sort(A); // A를 오름차순으로 정렬합니다.

        Integer[] B = new Integer[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B, Comparator.reverseOrder()); // B를 내림차순으로 정렬합니다

        int ans = 0;
        for (int i = 0; i < N; i++) { // A의 가장 작은 값과 B의 가장 큰 값을 곱해서 더합니다.
            ans += A[i] * B[i];
        }

        bw.write(ans + "\n");
        bw.flush(); // 버퍼를 정리합니다.
        bw.close();
        br.close();
    }

}