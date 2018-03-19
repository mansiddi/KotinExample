package com.example.kotlinhelloworld.kotlin.collection

/**
 * Created by ManzarSiddique on 18-07-2017.
 */
/**
 * Properties stored in a map. This comes up a lot in applications like parsing JSON
 * or doing other "dynamic" stuff. Delegates take values from this map (by the string keys -
 * names of properties). Of course, you can have var's as well,
 * that will modify the map upon assignment (note that you'd need MutableMap instead of read-only Map).
 */

class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

fun main(args: Array<String>) {
    val user = User(mapOf(
            "name" to "John Doe",
            "age"  to 25
    ))

    println("name = ${user.name}, age = ${user.age}")

    val items = listOf(20, 34, 21, 87, 92,99)
    topTwo(items)
}


/*Write a program to find top two maximum numbers in the
given array. You should not use any sorting functions. You
should iterate the array only once. You should not use any
kind of collections in java.*/
fun topTwo(list: List<Int>){
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
