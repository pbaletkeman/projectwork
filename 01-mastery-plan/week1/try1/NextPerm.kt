class NextPerm {

    fun nextPerm(nums: IntArray) {
        val n = nums.size

        var i = n - 2

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--
        }

        if (i >= 0) {
            var j = n - 1
            while (nums[j] <= nums[i]) {
                j--
            }
            swap(nums, i, j)
        }
        reverse(nums, i + 1, n - 1)
    }

    private fun swap(nums: IntArray, a: Int, b: Int) {
        val temp = nums[a]
        nums[a] = nums[b]
        nums[b] = temp
    }

    private fun reverse(nums: IntArray, l: Int, r: Int) {
        var left = l
        var right = r
        while (left < right) {
            swap(nums, left++, right--)
        }
    }

    fun nextPerm(letters: CharArray) {
        val n = letters.size

        var i = n - 2

        while (i >= 0 && letters[i] >= letters[i + 1]) {
            i--
        }

        if (i >= 0) {
            var j = n - 1
            while (letters[j] <= letters[i]) {
                j--
            }
            swap(letters, i, j)
        }
        reverse(letters, i + 1, n - 1)
    }

    private fun swap(letters: CharArray, a: Int, b: Int ) {
        val temp = letters[a]
        letters[a] = letters[b]
        letters[b] = temp
    }

    private fun reverse(letters: CharArray, l: Int, r: Int) {
        var left = l
        var right = r
        while (left < right) {
            swap(letters, left++, right--)
        }
    }
}

fun main() {
    val nextPerm = NextPerm()
    val a = charArrayOf('a','b','c')
    nextPerm.nextPerm(a)
    println(String(a))

    val b = intArrayOf(1,2,3)
    nextPerm.nextPerm(b)
    println(b.joinToString())
}
