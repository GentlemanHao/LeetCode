fun main() {
    println(climbStairs(3))
    println(climbStairs(5))
}

fun climbStairs(n: Int): Int {
    if (n <= 3) return n

    var left1 = 2
    var left2 = 1
    var current = 3
    for (i in 4..n) {
        left2 = left1
        left1 = current
        current = left2 + left1
    }

    return current
}