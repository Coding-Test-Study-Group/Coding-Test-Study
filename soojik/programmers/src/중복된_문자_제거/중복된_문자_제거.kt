package 중복된_문자_제거

class Solution {
    fun solution(my_string: String): String {
        var answer: String = ""

        // 문자열 하나하나 순회하며 answer에 해당 문자가 없다면 추가하고, 아니면 수항 작업 없도록
        for (s in my_string) {
            if (answer.indexOf(s) < 0) {
                answer += s;
            }
        }

        return answer
    }
}

fun main() {
    println(Solution().solution("people"));
    println(Solution().solution("We are the world"));
}