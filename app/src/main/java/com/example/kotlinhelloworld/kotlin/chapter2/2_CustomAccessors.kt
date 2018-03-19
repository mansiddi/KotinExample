package com.example.kotlinhelloworld.kotlin.chapter2

/**
 * Created by ManzarSiddique on 17-07-2017.
 */
class `2_CustomAccessors` {

    class Rectangle(val height: Int, val width: Int) {
        val isSquare: Boolean
            get() {
                return height == width
            }
    }

    fun main(args: Array<String>) {
        val rectangle = Rectangle(41, 43)
        println(rectangle.isSquare)
    }
}