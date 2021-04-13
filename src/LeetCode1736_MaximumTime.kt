fun main() {
    println(maximumTime("2?:?0"))
}

fun maximumTime(time: String): String {
    val sb = StringBuilder(time)

    if (sb[0] == '?') {
        if (sb[1] == '?') {
            sb.replace(0, 2, "23")
        } else {
            sb.replace(0, 1, if (sb[1] > '3') "1" else "2")
        }
    }

    if (sb[1] == '?') {
        sb.replace(1, 2, if (sb[0] == '2') "3" else "9")
    }

    if (sb[3] == '?') {
        sb.replace(3, 4, "5")
    }

    if (sb[4] == '?') {
        sb.replace(4, 5, "9")
    }

    return sb.toString()
}