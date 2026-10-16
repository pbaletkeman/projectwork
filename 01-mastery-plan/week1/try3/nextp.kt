
class NextP {

    fun next(items: CharArray) {
        val n = items.size

        var i = n - 2;
        while (i >= 0 && items[i] > items[i + 1]) {
            i--
        }

        if (i >= 0) {

            var j = n - 1
            while (items[j] <= items[i]) {
                j--
            }
            swap(items, i, j)
        }

        reverse(items, i +1, n - 1)
    }

    private fun swap(items: CharArray, a: Int, b: Int) {
        val c = items[a]
        items[a] = items[b]
        items[b] = c
    }

    private fun reverse(items: CharArray, l: Int, r: Int) {
        var left = l
        var right = r
        while (left < right) {
            swap(items, left++, right--)
        }
    }

    fun next(items: IntArray) {
        val n = items.size

        var i = n - 2;
        while (i >= 0 && items[i] > items[i + 1]) {
            i--
        }

        if (i >= 0) {

            var j = n - 1
            while (items[j] <= items[i]) {
                j--
            }
            swap(items, i, j)
        }

        reverse(items, i +1, n - 1)
    }

    private fun swap(items: IntArray, a: Int, b: Int) {
        val c = items[a]
        items[a] = items[b]
        items[b] = c
    }

    private fun reverse(items: IntArray, l: Int, r: Int) {
        var left = l
        var right = r
        while (left < right) {
            swap(items, left++, right--)
        }
    }

}

fun main() {
    val nextp = NextP();
    var a = charArrayOf('a','b','c')
    nextp.next(a)
    println(a.joinToString(","))
    var b = intArrayOf(7,1,2,3,4,5,6,7)
    nextp.next(b)
    println(b.joinToString(","))
}
