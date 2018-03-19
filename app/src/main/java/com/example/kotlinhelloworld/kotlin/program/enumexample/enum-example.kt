package com.example.kotlinhelloworld.kotlin.program.enumexample

/**
 * Created by ManzarSiddique on 25-07-2017.
 */
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
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
    println(swichCase(Color.BLUE))
}
