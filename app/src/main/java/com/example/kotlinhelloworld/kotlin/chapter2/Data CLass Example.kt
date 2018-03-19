package com.example.kotlinhelloworld.kotlin.chapter2

/**
 * Created by ManzarSiddique on 18-07-2017.
 */
/**
 *  Data class gets component functions, one for each property declared
 *  in the primary constructor, generated automatically, same for all the
 *  other goodies common for data: toString(), equals(), hashCode() and copy().
 *  See http://kotlinlang.org/docs/reference/data-classes.html#data-classes
 */

data class User(val name: String, val id: Int)

fun getUser(): User {
    return User("Alex", 1)
}

fun main(args: Array<String>) {
    val user = getUser()
    println("name1 = ${user.name}, id = ${user.id}")

    // or

    val (name, id) = getUser()
    println("name2 = $name, id = $id")

    // or

    println("name3 = ${getUser().component1()}, id = ${getUser().component2()}")
}
