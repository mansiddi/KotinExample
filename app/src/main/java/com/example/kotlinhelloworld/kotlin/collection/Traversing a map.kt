package com.example.kotlinhelloworld.kotlin.collection

/**
 * Created by ManzarSiddique on 18-07-2017.
 */
/**
 *  Kotlin Standard Library provide component functions for Map.Entry
 */

fun main(args: Array<String>) {
    val map = hashMapOf<String, Int>()
    map.put("one", 1)
    map.put("two", 2)

    for ((key, value) in map) {
        println("key = $key, value = $value")
    }

    for (m in map) {
        println("key is $m")
    }

//    Filtering a list
    val list = listOf(1, 2, 3, 4)
    val positive = list.filter { x -> x > 0 }
//    Or alternatively, even shorter:
    val positives = list.filter { it > 0 }
}

/* Output
key = one, value = 1
key = two, value = 2
------------------------
key is one=1
key is two=2 */