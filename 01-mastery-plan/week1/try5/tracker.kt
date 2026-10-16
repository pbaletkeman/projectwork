
fun track(results: MutableList<String>, s: String, used: BooleanArray, path: String) {
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
        track(results, s, used, path + s[i])
        used[i] = false
    }
}

fun values(word: String): List<String> {
    val results = mutableListOf<String>()
    val s = word.toList().sorted().joinToString("")
    val used = BooleanArray(s.length)
    track(results, s, used, "")
    return results
}

fun main(args: Array<String>) {
    println(values("pete"))
}
