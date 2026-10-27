import java.time.LocalDateTime

data class Item (val itemId: String, val name: String, val createDateTime: LocalDateTime)

fun findFirstAfter(items: Array<Item>, target: Item): Item? {
    var left = 0
    var right = items.size
    var candidate: Item? = null
    var mid = 0

    while (left <= right) {
        mid = (left + right) / 2

        if (items[mid].createDateTime.isAfter(target.createDateTime)) {
            candidate = items[mid]
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return candidate
}

fun findLastBefore(items: Array<Item>, target: Item): Item? {
    var left = 0
    var right = items.size
    var candidate: Item? = null
    var mid = 0

    while (left <= right) {
        mid = (left + right) / 2

        if (items[mid].createDateTime.isBefore(target.createDateTime)) {
            candidate = items[mid]
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return candidate
}

fun findItem(items: Array<Item>, target: Item): Item? {
    var left = 0
    var right = items.size
    var mid = 0

    while (left <= right) {
        mid = (left + right) / 2

        if (items[mid].createDateTime.isEqual(target.createDateTime)) {
            return items[mid]
        }

        if (items[mid].createDateTime.isBefore(target.createDateTime)) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return null
}

fun createSampleData(length: Int): Array<Item> {
    val retval = Array(length) {index ->
        Item(index.toString(), "name-$index", LocalDateTime.of(2026, 5, index + 1, 2, 0))
    }
    return retval
}

fun main() {
    val items = createSampleData(10)
    var target = Item("4", "name-4", LocalDateTime.of(2026, 5, 5, 2, 0))
    val exact = findItem(items, target)
    println(items.joinToString())
    println("-----------------------")
    println("Exact")
    println("============")
    println("target:")
    println(target)
    println("result:")
    println(exact)
    println("-----------------------")

    target = Item("4", "name-4", LocalDateTime.of(2026, 5, 5, 12, 0))
    var after = findFirstAfter(items, target)
    println("-----------------------")
    println("After")
    println("============")
    println("target:")
    println(target)
    println("result:")
    println(after)
    println("-----------------------")

    target = Item("4", "name-4", LocalDateTime.of(2026, 5, 2, 1, 0))
    var before = findLastBefore(items, target)
    println("-----------------------")
    println("Before")
    println("============")
    println("target:")
    println(target)
    println("result:")
    println(before)
    println("-----------------------")
}
