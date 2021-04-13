import java.util.*
import kotlin.collections.ArrayList

fun main() {
    permute1(intArrayOf(1, 2, 3))
}

fun permute1(nums: IntArray): List<List<Int>> {
    val res = ArrayList<List<Int>>()
    backtrack1(nums.size, nums.toList(), res, 0)
    return res
}

fun backtrack1(size: Int, output: List<Int>, res: ArrayList<List<Int>>, first: Int) {
    if (first == size) {
        println("============================== $output")
        res.add(ArrayList<Int>(output))
    }

    for (i in first until size) {
        Collections.swap(output, first, i)
        backtrack1(size, output, res, first + 1)
        Collections.swap(output, first, i)
    }
}

fun permute2(nums: IntArray): List<List<Int>> {
    val res: LinkedList<List<Int>> = LinkedList()

    val track: LinkedList<Int> = LinkedList()
    backtrack2(nums, track, res)

    return res
}

fun backtrack2(nums: IntArray, track: LinkedList<Int>, res: LinkedList<List<Int>>) {
    if (track.size == nums.size) {
        println("============================== $track")
        res.add(LinkedList(track))
        return
    }

    for (i in nums.indices) {
        println("$i ========= $track")
        if (track.contains(nums[i])) continue

        track.add(nums[i])
        backtrack2(nums, track, res)
        track.removeLast()
    }
}