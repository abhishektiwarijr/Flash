package leetcode

fun main() {
    println(productOfArrayExceptSelfMine(intArrayOf(1, 2, 3, 4, 5)).contentToString()) //[120,60,40,30,24]
    println(productOfArrayExceptSelfMine(intArrayOf(-1, 1, 0, -3, 3)).contentToString()) //[0,0,9,0,0]
    println(productOfArrayExceptSelfMine(intArrayOf(1,2,3,4)).contentToString()) //[24,12,8,6]
}

private fun productOfArrayExceptSelfMine(arr: IntArray): IntArray {
    val result = IntArray(arr.size) { 1 }
    val size = arr.size
    var prefix = 1
    var postfix = 1

    for (i in 0..arr.lastIndex) {
        result[i] *= prefix
        prefix *= arr[i]

        //result[size - i - 1] *= postfix
        //postfix *= arr[size - i - 1]
    }

    for (i in arr.lastIndex downTo 0) {
        result[i] *= postfix
        postfix *= arr[i]
    }

    return result
}

private fun productOfArrayExceptSelf(arr: IntArray): IntArray {
    val result = IntArray(arr.size)
    for (i in 0..arr.lastIndex) {
        var prod = 1
        for (j in 0..arr.lastIndex) {
            if (i == j) continue
            else {
                prod *= arr[j]
            }
        }
        result[i] = prod
    }
    return result
}

fun productExceptSelf(nums: IntArray): IntArray {
    //Prefix Product
    val prefix = IntArray(nums.size)
    prefix[0] = 1
    for (i in 1..prefix.lastIndex) {
        prefix[i] = nums[i - 1] * prefix[i - 1]
    }

    //Suffix Product
    val suffix = IntArray(nums.size)
    suffix[nums.size - 1] = 1
    for (i in (nums.size - 2) downTo 0) {
        suffix[i] = nums[i + 1] * suffix[i + 1]
    }

    //Final Product
    val result = IntArray(nums.size)
    for (i in 0..nums.lastIndex) {
        result[i] = prefix[i] * suffix[i]
    }

    return result
}

fun productExceptSelfFast(nums: IntArray): IntArray {
    val product = IntArray(nums.size)
    product[0] = 1
    for (i in 1..product.lastIndex) {
        product[i] = nums[i - 1] * product[i - 1]
    }
    var suffixProduct = 1
    for (i in (nums.size - 1) downTo 0) {
        product[i] = product[i] * suffixProduct
        suffixProduct *= nums[i]
    }
    return product
}

fun productExceptSelfFast2(nums: IntArray): IntArray {
    val product = IntArray(nums.size) { 1 }
    val size = nums.size
    var prefix = 1
    var suffix = 1
    for (i in 0..product.lastIndex) {
        product[i] *= prefix
        prefix *= nums[i]
        product[size - i - 1] *= suffix
        suffix *= nums[size - i - 1]
    }
    return product
}