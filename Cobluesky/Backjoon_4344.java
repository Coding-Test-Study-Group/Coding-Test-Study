import jdk.jshell.EvalException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Backjoon_4344 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // BufferedReader 가공을 위해 StringTokenizer를 정의합니다.

        int testCaseCount = Integer.parseInt(br.readLine()); // 테스트케이스의 개수를 받습니다.

        for (int i = 0; i < testCaseCount; i++) { // 테스트케이스만큼 반복합니다.
            st = new StringTokenizer(br.readLine(), " "); // 공백으로 분리합니다.
            int scoreCount = Integer.parseInt(st.nextToken());
            int [] scoreArr = new int[scoreCount]; // 배열에 저장합니다.

            double sum = 0; // 합을 저장합니다.

            for (int j = 0; j < scoreCount; j++) {
                int val = Integer.parseInt(st.nextToken());
                scoreArr[j] = val;
                sum += val; // 값을 더합니다.
            }

            double avg = (dobule) (sum / scoreCount); // 평균을 구합니다.

            int count = 0; 

            for (int k = 0; k < scoreCount; k++) {
                if (scoreArr[k] > avg) {
                    count++; // 평균 이상인 사람의 수를 구합니다.
                }
            }

            System.out.printf("%.3f%%\n", (count / scoreCount) * 100); // 비율을 구합니다.
        }
    }

}
