package jiWoo.프로그래머스;
import java.util.*;
public class 프로그래머스_두원사이의정수쌍 {
    public long solution(int r1, int r2) {
        long answer = 0;

        // 1사분면에서 x축과 y축을 제외한 개수 세주기
        // i: x축의 좌표를 1부터 r2미만까지 체크한다.
        // start, end는 x값이 i일 때 가능한 y좌표의 시작과 끝이다.
        // start는 더 작은 원 위에 i값을 넣었을 때보다 크거나 같은 정수
        // end는 큰 원 위에 i값을 넣었을 때보다 작거나 같은 정수
        // x가 i일 때 가능한 좌표는 start부터 end까지의 정수
        for (int i = 1; i < r2; i++) {
            // start 예외 처리
            // 작은 원 위에 해당하는 0~r1까지와 r1~r2 분리
            // start가 정수가 아니거나 y축 위에 있으면 ++
            double start = 0.0;
            if (i > r1) start = 1.0;
            else {
                start = Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));
                if (start % 1 != 0.0 || start == 0.0) start++;
            }

            double end = Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
            if(start > end) continue;

            answer += ((long)end - (long)start + 1);
        }

        // 현재 1사분면만 세주었기 때문에 4를 곱한다.
        answer *= 4;

        // x축과 y축 위에 있는 좌표들도 세어주기
        answer += (r2 - r1 + 1) * 4;
        return answer;
    }
}
