package com.example.kotlinhelloworld.kotlin.chapter2

/**
 * Created by ManzarSiddique on 18-07-2017.
 */
/**
 * Data class gets next functions, generated automatically:
 * component functions, toString(), equals(), hashCode() and copy().
 * See http://kotlinlang.org/docs/reference/data-classes.html#data-classes
 */

data class UserX(val name: String, val id: Int)

fun main(args: Array<String>) {
    val user = UserX("Alex", 1)
    println(user) // toString()

    val secondUser = UserX("Alex", 1)
    val thirdUser = UserX("Max", 2)

    println("user == secondUser: ${user == secondUser}")
    println("user == thirdUser: ${user == thirdUser}")

    // copy() function
    println(user.copy())
    println(user.copy("Max"))
    println(user.copy(id = 2))
    println(user.copy("Max", 2))
}
