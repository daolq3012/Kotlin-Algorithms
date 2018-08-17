package extention

/**
 * Helper method for swapping places in array
 * @param idx index of the first element
 * @param idy index of the second element
 */
fun <T : Any> ArrayList<T>.swap(idx: Int, idy: Int) {
    val temp = this[idx]
    this[idx] = this[idy]
    this[idy] = temp
}
