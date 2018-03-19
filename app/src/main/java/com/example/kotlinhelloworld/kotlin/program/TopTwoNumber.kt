package com.example.kotlinhelloworld.kotlin.program

/**
 * Created by ManzarSiddique on 18-07-2017.
 */

/*Write a program to find top two maximum numbers in the given array. You should not use any sorting functions. You
    should iterate the array only once. You should not use any kind of collections in java.*/

class TopTwoNumber {

    fun main(args: Array<String>) {
        val list = listOf(20, 34, 21, 87, 92,99)
        val array = arrayOf(22, 33, 221, 83217, 9112,199)
        topTwoFromList(list)
        topTwoFromArray(array)
    }



    fun topTwoFromList(list: List<Int>){
        var max1: Int = 0
        var max2: Int = 0
        for (number in list) {
            if (number > max1) {
                max2 = max1
                max1 = number
            } else if (number > max2){
                max2 = number
            }
        }
        println("Given integer array : " +list);
        println("First maximum number is : " + max1);
        println("Second maximum number is : " + max2);
    }

    fun topTwoFromArray(array: Array<Int>){
        var max1: Int = 0
        var max2: Int = 0
        for (number in array) {
            if (number > max1) {
                max2 = max1
                max1 = number
            } else if (number > max2){
                max2 = number
            }
        }
        println("Given integer array : " +array);
        println("First maximum number is : " + max1);
        println("Second maximum number is : " + max2);
    }



}