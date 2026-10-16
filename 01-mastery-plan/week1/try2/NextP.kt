class NextP {

    fun nextPerm(num: IntArray) {
        val n = num.size

        var i = n - 2
        while (i >= 0 && num[i] > num[i + 1]) {
            i--;
        }

        if (i >= 0) {
            var j = n - 1
            while (num[j] <= num[i]) {
                j--
            }
            swap(num, i, j)
        }
        reverse(num, i + 1, n - 1)
    }

    private fun swap(n: IntArray, i: Int, j: Int){
        val t = n[i]
        n[i] = n[j]
        n[j] = t
    }

    private fun reverse(n: IntArray, l: Int, r: Int) {
        var left = l
        var right = r
        while (left < right) {
            swap(n, left++, right--)
        }
    }

    fun nextPerm(chr: CharArray) {
        val n = chr.size

        var i = n - 2
        while (i >= 0 && chr[i] > chr[i+1]) {
            i--
        }

        if (i >= 0) {
            var j = n - 1
            while (chr[j] <= chr[i]) {
                j--
            }
            swap(chr, i, j)
        }
        reverse(chr, i + 1, n - 1)
    }

    private fun swap(n: CharArray, i: Int, j: Int) {
        val t = n[i]
        n[i] = n[j]
        n[j] = t
    }

    private fun reverse(chr: CharArray, l: Int, r: Int) {
        var left = l
        var right = r
        while (left < right) {
            swap(chr, left++, right--)
        }
    }
}

fun main() {
    var a = intArrayOf(1,2,3)
    NextP().nextPerm(a)
    println(a.joinToString())
    var b = charArrayOf('a', 'b', 'c')
    NextP().nextPerm(b)
    println(b.joinToString())
}
