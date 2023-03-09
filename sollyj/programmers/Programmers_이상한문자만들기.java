// Programmers_이상한문자만들기
package sollyj.programmers;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Programmers_이상한문자만들기 {
	public static void main(String[] args) {
		System.out.println(solution("Hello World"));    // 예시 입력1
		System.out.println(solution("hello kitty lili"));    // 예시 입력2
		System.out.println(solution("I LOVe a pizza   "));    // 예시 입력3
	}

	private static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		String answer = "";

		// 입력3과 같이 문자열 맨뒤에 공백이 있을경우
		// split 조건을 -1을 해야 맨뒤 공백도 카운트 된다.
		int len = s.split(" ", -1).length;    // 공백을 기준으로 나눈 단어 개수
		ArrayList<String> words = new ArrayList<>(len);    // 공백을 기준으로 나눈 단어들 배열

		for (int i = 0; i < len; i++) {
			words.add(s.split(" ", -1)[i]);
		}

		// 단어들 조건대로 매핑함
		Stream<String> mappedWords = words.stream().map(word -> {
			String newWord = "";

			for (int i = 0; i < word.length(); i++) {
				if (i % 2 == 0) {   // 짝수번째면 대문자로
					newWord += word.substring(i, i + 1).toUpperCase();
				} else {    // 홀수번째면 소문자로
					newWord += word.substring(i, i + 1).toLowerCase();
				}
			}

			return newWord;
		});

		mappedWords.forEach(mappedWord -> sb.append(mappedWord + " "));

		answer = sb.substring(0, sb.length() - 1);

		return answer;
	}
}