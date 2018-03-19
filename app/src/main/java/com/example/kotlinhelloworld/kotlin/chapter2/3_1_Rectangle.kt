package com.example.kotlinhelloworld.kotlin.chapter2

import java.util.*

/**
 * Created by ManzarSiddique on 17-07-2017.
 */
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}