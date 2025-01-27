package jorgemrj.extensions

import jorgemrj.models.Vehiculo


inline fun <T> Array<T?>.countBy(predicate: (T) -> Boolean = { true }): Int {
    var count = 0
    for (element in this) {
        if (element != null && predicate(element)) {
            count++
        }
    }
    return count
}

inline fun <reified T> Array<T?>.filterBy(predicate: (T) -> Boolean): Array<T> {
    val count = this.count { it != null && predicate(it) }
    val result = Array<T>(count) {null as T}

    var index = 0
    for (item in this) {
        if (item != null && predicate(item)) {
            result[index] = item
            index++
        }
    }

    return result
}

fun <T> Array<T?>.forEach(action: (T) -> Unit) {
    for (item in this) {
        if (item != null) {
            action(item)
        }
    }
}

fun <T> Array<T?>.indexOf(condition: (T?) -> Boolean): Int {
    for (index in this.indices) {
        if (condition(this[index])) {
            return index
        }
    }
    return -1
}

fun <T> Array<T?>.averageBy(predicate: (T) -> Boolean): Double {
    var count = 0
    var total = 0.0
    for (element in this) {
        if (element != null && predicate(element)) {
            total += (element as? Number)?.toDouble() ?: 0.0
            count++
        }
    }
    return if (count == 0) 0.0 else total / count
}

fun <T> Array<T?>.sumBy(predicate: (T) -> Boolean): Double {
    var total = 0.0
    for (element in this) {
        if (element != null && predicate(element)) {
            total += element.toString().toDouble()
        }
    }
    return total
}

fun <T> Array<T?>.firstOrNull(predicate: (T) -> Boolean = { true }): T? {
    for (element in this) {
        if (element != null && predicate(element)) {
            return element
        }
    }
    return null
}

fun <T> Array<T?>.lastOrNull(predicate: (T) -> Boolean = { true }): T? {
    var lastMatch: T? = null
    for (element in this) {
        if (element != null && predicate(element)) {
            lastMatch = element
        }
    }
    return lastMatch
}

fun <T> Array<T?>.maxByOrNull(selector: (Vehiculo) -> Int, predicate: (T) -> Boolean): T? {
    var maxElement: T? = null
    var maxValue: Int? = null
    for (element in this) {
        if (element != null && predicate(element)) {
            val value = selector(element as Vehiculo)
            if (maxValue == null || value > maxValue) {
                maxValue = value
                maxElement = element
            }
        }
    }
    return maxElement
}

fun <T> Array<T?>.minByOrNull(selector: (Vehiculo) -> Int, predicate: (T) -> Boolean): T? {
    var minElement: T? = null
    var minValue: Int? = null
    for (element in this) {
        if (element != null && predicate(element)) {
            val value = selector(element as Vehiculo)
            if (minValue == null || value < minValue) {
                minValue = value
                minElement = element
            }
        }
    }
    return minElement
}

inline fun <reified T> Array<T?>.redimensionar(modo: ModoRedimension, maxItems: Int): Array<T?> {
    val nuevoArray = arrayOfNulls<T>(maxItems)
    var index = 0
    for (item in this) {
        if (item != null || modo != ModoRedimension.DIS) {
            nuevoArray[index] = item
            if (index < maxItems - 1) index++
        }
    }
    return nuevoArray
}

inline fun <reified T> Array<T?>.sortedBy(
    mode: ModoOrdenamiento = ModoOrdenamiento.DESC,
    selector: (T) -> Double
): Array<T> {
    val result = this.filterBy { true }
    val compare: (Double, Double) -> Boolean =
        if (mode == ModoOrdenamiento.ASC) { a, b -> a > b } else { a, b -> a < b }

    for (i in result.indices) {
        for (j in 0..<result.size - 1 - i) {
            if (compare(selector(result[j]), selector(result[j + 1]))) {
                result[j] = result[j + 1].also { result[j + 1] = result[j] }
            }
        }
    }
    return result
}

enum class ModoRedimension {
    AUM, DIS
}

enum class ModoOrdenamiento {
    ASC, DESC
}