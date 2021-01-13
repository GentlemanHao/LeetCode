import java.util.*

fun main() {
    //println(isValid("[]{}()"))
    println(isValid("[]  {}()"))
}

fun isValid(s: String): Boolean {
    if (s.length % 2 != 0) return false

    val map = mapOf(')' to '(', ']' to '[', '}' to '{')

    val stack = Stack<Char>()
    s.forEach { c ->
        if (map.containsKey(c)) {
            if (stack.isEmpty() || stack.peek() != map[c]) {
                return false
            }
            stack.pop()
        } else {
            if (c != ' ') {
                stack.push(c)
            }
        }
    }

    return stack.isEmpty()
}