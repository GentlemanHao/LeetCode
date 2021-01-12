
fun main() {
    val ints = intArrayOf(6, 1, 2, 7, 9, 3, 4, 5, 10, 8)
    println(ints.contentToString())
    //quickSort(ints, 0, ints.size - 1)
    popSort(ints)
    println(ints.contentToString())
}

fun quickSort(nums: IntArray, start: Int, end: Int) {
    if (start >= end) return
    var left = start
    var right = end
    val temp = nums[left] // 默认左边第一位是基准数

    while (left < right) {
        // 从右开始找小于基准数的
        while (nums[right] >= temp && left < right) right--

        // 从左开始找大于基准数的
        while (nums[left] <= temp && left < right) left++

        // 交换左右目标数位置
        if (left < right) {
            val swap = nums[left]
            nums[left] = nums[right]
            nums[right] = swap
        }
    }

    // 交换基准数位置，左边全部小于基准数，右边全部大于基准数
    nums[start] = nums[left]
    nums[left] = temp

    quickSort(nums, start, left - 1)
    quickSort(nums, left + 1, end)
}

/**
 *原理：比较相邻的两个元素，将较大的元素交换至右端。
 *思路：依次比较相邻的两个元素，将小数放前边，大数放后边；
 *第一趟比较完成后，最后一个数一定是数组中最大的一个数，所以第二趟比较的时候最后一个数不参与比较，依次类推，每一趟比较次数-1。
 */
fun popSort(nums: IntArray) {
    for (i in nums.indices) {
        for (j in 0 until nums.size - 1 - i) {
            if (nums[j] > nums[j + 1]) {
                val temp = nums[j]
                nums[j] = nums[j + 1]
                nums[j + 1] = temp
            }
        }
        println(nums.contentToString())
    }
}
