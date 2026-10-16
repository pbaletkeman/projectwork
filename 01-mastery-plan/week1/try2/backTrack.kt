
fun backTrack(results: MutableList<String>, s: String, used: BooleanArray, path: String) {
    if (s.length == path.length) {
        results.add(path)
        return
    }

    for (i in s.indices) {
        if (used[i]) {
            continue
        }

        if (i > 0 && s[i] == s[i - 1] && !used[i - 1]) {
            continue
        }

        used[i] = true
        backTrack(results, s, used, path + s[i])
        used[i] = false
    }

}

fun permutate(word: String): List<String> {
    val results = mutableListOf<String>()
    val usedElements = BooleanArray(word.length)
    val chrs = word.toList().sorted().joinToString("")
    backTrack(results, chrs, usedElements, "")
    return results
}

fun main(args: Array<String>) {
    println(permutate("pete"))
}
