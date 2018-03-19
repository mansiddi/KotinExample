package com.example.kotlinhelloworld.kotlin.program

/**
 * Created by ManzarSiddique on 18-07-2017.
 */

fun main(args: Array<String>) {

    val arr = intArrayOf(2, 4, 6, 8, 10, 12, 14, 16)
    println("Key 14's position: ${binarySearch(arr, 14)}")
    val arr1 = intArrayOf(6, 34, 78, 123, 432, 900)
    println("Key 432's position: " + binarySearch(arr1, 432))
}


fun binarySearch(inputArr: IntArray, key: Int): Int {

    var start = 0
    var end = inputArr.size - 1
    while (start <= end) {
        val mid = (start + end) / 2
        if (key == inputArr[mid]) {
            return mid
        }
        if (key < inputArr[mid]) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return -1
}