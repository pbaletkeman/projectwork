
fun backTrack(result: MutableList<String>, s: String, used: BooleanArray, path: String) {
    if (path.length == s.length) {
        result.add(path)
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

        backTrack(result, s, used, path + s[i])

        used[i] = false
    }
}

fun perumate(word: String): List<String> {
    val results = mutableListOf<String>()
    val used = BooleanArray(word.length)
    val chars = word.toList().sorted().joinToString("")
    backTrack(results, chars, used, "")
    return results
}

fun main(args: Array<String>) {
    println(perumate("pete"))
}
