package com.example.kotlinhelloworld.kotlin.program

/**
 * Created by ManzarSiddique on 24-07-2017.
 */


/* All for loop in kotlin as ranges
            *
            *
            for (i in 1..100) { ... }  // closed range: includes 100
            for (i in 1 until 100) { ... } // half-open range: does not include 100
            for (x in 2..10 step 2) { ... }
            for (x in 10 downTo 1) { ... }
            if (x in 1..10) { ... }
            *
            *
            * */
fun main(args: Array<String>){
    println("Main")
    listExample()
}

fun listExample(){
    // closed range: includes 100
    for (i in 1..100){
        println("i : "+i)
    }

    // half-open range: does not include 100
    for (i in 1 until 100) {
        println("i until 100 : "+i)
    }

    //Reverse for loop
    for (x in 10 downTo 1) {
        println("Reverse for loop i: "+x)
    }

    // starts from 2 and print every 3 item
    for (x in 2..10 step 3) {
        println("x : "+x)
    }
}