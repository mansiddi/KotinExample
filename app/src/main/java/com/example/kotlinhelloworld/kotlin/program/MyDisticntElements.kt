package com.example.kotlinhelloworld.kotlin.program

/**
 * Created by ManzarSiddique on 18-07-2017.
 */


/* The below example shows how to avoid duplicate elements from an array and disply only distinct elements. Please use only arrays to process it.*/

fun main(a: Array<String>){

    val nums = intArrayOf(5, 2, 7, 2, 4, 7, 8, 2, 3)
    printDistinctElements(nums)
}

fun printDistinctElements(arr: IntArray) {

    for (i in arr.indices) {
        var isDistinct = false
        for (j in 0..i - 1) {
            if (arr[i] == arr[j]) {
                isDistinct = true
                break
            }
        }
        if (!isDistinct) {
            print(arr[i].toString() + " ")
        }
    }
}

