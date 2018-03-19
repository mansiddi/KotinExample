package com.example.kotlinhelloworld.kotlin.program

import java.util.*

/**
 * Created by ManzarSiddique on 19-07-2017.
 */
fun main(args: Array<String>){

    //Read-only list
    val list = listOf("a", "b", "c")

    //Read-only map
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)

    //Accessing a map
    println(map["a"])
//    map["key"] = value

    //    Traversing a map/list of pairs
    for ((key, value) in map) {
        println("$key -> $value")
    }
//    k, v can be called anything.


    /*List of map example*/
    val map1 = mapOf("a" to map, "b" to 2, "c" to 3)
    val map2 = mapOf("a" to 1, "b" to 2, "c" to 3)
    val map3 = mapOf("a" to 1, "b" to 2, "c" to 3)

    var mapList = listOf(map, map1, map2, map3)

    println(mapList.get(1).keys)    // [a, b, c]
    println(mapList.get(1).entries) // [a=1, b=2, c=3]
    println(mapList.get(1).get("a"))    // 1
    println(mapList.get(1)["b"])    // 2


    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary  //adding to map as key and value in one line
    }
    //Iterating a map as key and value
    if (!binaryReps.isEmpty()){
        for ((letter, binary) in binaryReps) {
            println("$letter = $binary")
        }
    }

    A().test1()
    D().test1()

}



//    If you use the map function, you can write this as a single expression...

/*fun arrayToList(data: JSONArray, key: String): List<String> =
        data.map { it[key].asString }
        //    OR
        data.map{ a -> a[key].asString }*/

/*The map function takes an argument of one type and turns it into another.
 I'm also taking advantage of the fact that the default element name in Kotlin is called it,
 so I don't have to define something explicitly like I would in (say) Java.
 So what this says is "for each object in data, get the key value and call .asString on it.
This is automatically converted to a List.*/