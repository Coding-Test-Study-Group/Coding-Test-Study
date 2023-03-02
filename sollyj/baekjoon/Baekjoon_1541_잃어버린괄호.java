// Baekjoon_1541_잃어버린괄호
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_1541_잃어버린괄호 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String formula = br.readLine();
			int answer = 0;

			// -를 기준으로 문자열 나누기
			String[] split = formula.split("-");

			for (int i = 0; i < split.length; i++) {
				// +가 있는 문자열은 더한 값이 들어가고
				// +가 없는 문자열은 그냥 그 값이 들어간다.
				int sum = mySum(split[i]);

				if (i == 0)    // 가장 앞에 있는 값만 더하고
					answer += sum;
				else    // 아니면 빼준다
					answer -= sum;
			}

			System.out.println(answer);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	// +연산하는 함수
	private static int mySum(String data) {
		int sum = 0;
		String[] data_split = data.split("\\+");    // +로 구분하여
		for (String ds : data_split) {
			sum += Integer.parseInt(ds);    // 정수로 바꿔서 더해준다.
		}
		return sum;
	}
}
