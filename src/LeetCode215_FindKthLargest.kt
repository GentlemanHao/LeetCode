import java.util.*

fun main() {
    println(findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    println(findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
}

fun findKthLargest(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    return nums[nums.size - k]
}