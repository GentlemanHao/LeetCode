fun main() {
    val ints = intArrayOf(1, 2, 5)

    println(coinChange1(ints, 7))
}

// 1. 超出时间限制
fun coinChange1(coins: IntArray, amount: Int): Int {
    return coinChange1(0, coins, amount)
}

fun coinChange1(indexCoin: Int, coins: IntArray, amount: Int): Int {
    if (amount == 0) return 0

    if (indexCoin < coins.size && amount > 0) {
        val maxVal = amount / coins[indexCoin]
        var minCost = Int.MAX_VALUE
        for (i in 0..maxVal) {
            if (amount >= i * coins[indexCoin]) {
                val count = coinChange1(indexCoin + 1, coins, amount - i * coins[indexCoin])
                if (count != -1) {
                    minCost = Math.min(minCost, count + i)
                }
            }
        }
        return if (minCost == Int.MAX_VALUE) -1 else minCost
    }

    return -1
}

// 2.
fun coinChange2(coins: IntArray, amount: Int): Int {
    return coinChange2(coins, amount, IntArray(amount))
}

fun coinChange2(coins: IntArray, amount: Int, counts: IntArray): Int {
    if (amount < 0) return -1
    if (amount == 0) return 0

    if (counts[amount - 1] != 0) return counts[amount - 1]

    var min = Int.MAX_VALUE
    coins.forEach { coinValue ->
        val result = coinChange2(coins, amount - coinValue, counts)
        if (result in 0 until min) {
            min = result + 1
        }
    }
    counts[amount - 1] = if (min == Int.MAX_VALUE) -1 else min
    return counts[amount - 1]
}