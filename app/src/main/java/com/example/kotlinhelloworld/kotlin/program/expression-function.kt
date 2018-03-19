package com.example.kotlinhelloworld.kotlin.program

/**
 * Created by ManzarSiddique on 25-07-2017.
 */
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know…​"
}

fun main(args: Array<String>) {
    println(isLetter('q'))
    println(isNotDigit('x'))
    println(recognize('8'))

    val name = if (args.size > 0) args[0] else "Kotlin" //Expression condition
    println("Hello, $name!")
}
