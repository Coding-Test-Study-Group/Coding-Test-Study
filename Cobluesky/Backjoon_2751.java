// https://www.acmicpc.net/problem/2751
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Backjoon_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받습니다.
        StringBuilder sb = new StringBuilder(); // 효율적인 문자열 편집을 위해 StringBuilder를 사용합니다. String은 변경불가한 문자열을 생성합니다.

        int inputNum = Integer.parseInt(br.readLine()); // 첫 번째 값을 숫자로 받아 몇 개의 값을 더 받을지 정합니다.

        ArrayList<Integer> list = new ArrayList<>(); // Sort를 사용하기 위해 ArrayList를 만듭니다.

        for (int i = 0; i < inputNum; i++) {
            list.add(Integer.parseInt(br.readLine())); // 리스트에 값을 더합니다.
        }

        Collections.sort(list); // 정렬합니다.

        for (int value : list) {
            sb.append(value).append("\n"); // StringBuilder로 문자열을 만듭니다.
        }
        System.out.println(sb);
    }
}

//String Sort를 쓰지않고 Collections.Sort를 쓴 이유
//String Sort는 기본적으로 Quick Sort입니다. 평균적으로 우수한 성능을 자랑합니다만, 최악의 케이스에는 시간복잡도가 O(n^2)가 되어버리는 문제점이 있습니다.
//해당 문제에서는 Quick Sort를 저격하는 테스트 케이스가 존재하기 때문에 효율성 테스트에서 실패합니다.
//따라서 타 Sort를 써야하는데, 저는 Collection.sort를 사용하였습니다.
//Collection.sort는 Timsort로 정렬하기 때문에 최악의 경우에도 O(n) ~ O(nlogn)을 보장합니다.
