fun main() {
    println(findDuplicate(intArrayOf(2, 4, 5, 2, 3, 1, 6, 7)))
}

fun findDuplicate(nums: IntArray): Int {
    var min = 1
    var max = nums.size - 1

    while (min < max) {
        val mid = (min + max) / 2
        val count = nums.count { it <= mid }

        if (count > mid) { //表示重复数在1..mid中
            max = mid
        } else {
            min = mid + 1
        }
    }
    return min
}