import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (n, k) = readln().split(' ').map { it.toInt() }
    val coinList = mutableListOf<Int>()
    repeat(n) {
        coinList.add(readln().toInt())
    }

    var answer = 0
    for (coin in coinList.reversed()) {
        answer += k / coin
        k %= coin
    }

    print(answer)
}