import java.util.*

fun main() {
    println(largestNumber(intArrayOf(24, 5, 1, 18, 92, 5)))
}

fun largestNumber(nums: IntArray): String {
    val comparator = Comparator<Int> { a, b ->
        var sa = 10
        while (sa <= a) sa *= 10

        var sb = 10
        while (sb <= b) sb *= 10

        return@Comparator (b * sa + a) - (a * sb + b)

        //return@Comparator -"$a$b".compareTo("$b$a")
    }

    val array = nums.toTypedArray()
    Arrays.sort(array, comparator)
    if (array[0] == 0) return "0"

    return StringBuilder().apply { array.forEach { append(it) } }.toString()
}
