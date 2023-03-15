// Programmers_소수만들기
package sollyj.programmers;

public class Programmers_소수만들기 {
	static int answer;
	static boolean[] visited;    // 방문 여부 배열 전역에 선언

	public static void main(String[] args) {
		int[] input1 = {1, 2, 3, 4};
		int[] input2 = {1, 2, 7, 4, 6};

		System.out.println(solution(input2));
	}

	private static int solution(int[] nums) {
		answer = 0;
		visited = new boolean[nums.length];

		combination(nums, 0, nums.length, 3);

		return answer;
	}

	// 백트래킹 사용해서 조합 구현
	// 배열, 시작 인덱스, 배열 길이, 몇 개 뽑을건지
	private static void combination(int[] arr, int start, int n, int r) {
		if (r == 0) {
			int sum = 0;

			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					sum += arr[i];
				}
			}

			if (isPrime(sum)) {
				answer++;
			}

			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;    // 하나 뽑고
			combination(arr, i + 1, n, r - 1);    // r - 1개 뽑으러 다시 재귀
			visited[i] = false;    // r개 다 뽑았으면 다시 방문여부 초기화
		}
	}

	// 소수 판별 메서드
	private static boolean isPrime(int num) {
		if (num <= 1)
			return false;

		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}

		return true;
	}
}
