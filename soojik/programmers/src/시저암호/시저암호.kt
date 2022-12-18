package 시저암호

class Solution {
    fun solution(s: String, n: Int): String {
        // 주어진 s 문자열 char형의 배열을 charr가 참조하도록
        var charr = s.toCharArray();

        var len = s.length;

        // charr 배열 순회하며
        for (i in 0..len-1) {

            // 주어지는 문자가 알파벳 또는 공백인데, 공백은 따로 처리할 필요 없으므로
            if (charr[i].isLetter()) {

                // 일단 now_c가 현재 문자를 참조하도록 하고
                var now_c = charr[i].toInt();

                // now_c가 대문자라고 판단되었을 때
                if (65 <= now_c && now_c <= 90) {
                    // n만큼 뒤로 이동시킨 값이
                    now_c += n;

                    // 90을 넘어 대문자 범위를 벗어났다면 26을 빼준다.
                    // 이는 n이 1에서 25 사이의 수가 주어진다고 한 조건이 있었기 때문에 한번만 빼고 된다고 가정
                    if (now_c > 90) {
                        now_c -= 26;
                    }
                }
                // now_c가 소문자라고 판단되었을 때
                else if (97 <= now_c && now_c <= 122) {
                    // n만큼 뒤로 이동시킨 값이
                    now_c += n;

                    // 122을 넘어 소문자 범위를 벗어났다면 26을 빼준다.
                    if (now_c > 122) {
                        now_c -= 26;
                    }
                }

                // 바뀐 값을 charr 배열에 반영 해준다.
                charr.set(i, now_c.toChar());
            }
        }
        
        return String(charr);
    }
}

fun main() {
    var s = Solution();

    println(s.solution("AB", 1));
    println(s.solution("z", 1));
    println(s.solution("a B z", 4));
}