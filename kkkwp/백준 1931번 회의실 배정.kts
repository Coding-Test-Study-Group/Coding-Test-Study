import java.io.BufferedReader
import java.io.InputStreamReader

data class Meeting(var start: Int, var end: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var n = readln().toInt()
    val meetings = mutableListOf<Meeting>()

    repeat(n) {
        var (start, end) = readln().split(' ').map { it.toInt() }
        meetings.add(Meeting(start, end))
    }

    meetings.sortWith(compareBy({ it.end }, { it.start }))

    var answer = 1
    var now = meetings[0].end
    for (i in 1 until n) {
        if (meetings[i].start >= now) {
            answer++
            now = meetings[i].end
        }
    }
    print(answer)
}