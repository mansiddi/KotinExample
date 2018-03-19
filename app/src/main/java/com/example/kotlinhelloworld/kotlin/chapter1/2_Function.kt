package com.example.kotlinhelloworld.kotlin.chapter1

/**
 * Created by ManzarSiddique on 17-07-2017.
 */
class `2_Function` {

    fun max(x: Int, y: Int): Int {
        return if (x > y) x else y
    }

    fun main(args: Array<String>) {
        print(max(2,4))
    }
}