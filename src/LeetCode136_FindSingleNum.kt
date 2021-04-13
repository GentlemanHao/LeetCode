fun main() {

    println(singleNumber(intArrayOf(2, 2, 4, 8, 7, 7, 5, 3, 3, 5, 4)))
}

/**
 * and 全1为1
 * or  有1为1
 * xor 不同为1
 */

fun singleNumber(nums: IntArray): Int {
    var num = 0
    nums.forEach { num = num xor it }
    return num
}