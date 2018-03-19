package com.example.kotlinhelloworld.kotlin.program

import com.example.kotlinhelloworld.kotlin.program.enumexample.Color

/**
 * Created by ManzarSiddique on 25-07-2017.
 */
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun swichCase(color: Color) =
        when (color) {
            Color.RED -> "Richard"
            Color.ORANGE -> "Of"
            Color.YELLOW -> "York"
            Color.GREEN -> "Gave"
            Color.BLUE -> "Battle"
            Color.INDIGO -> "In"
            Color.VIOLET -> "Vain"
        }

fun main(args: Array<String>) {
    for (i in 1..100) {
        println(fizzBuzz(i))
        println(swichCase(Color.ORANGE))
    }
}
