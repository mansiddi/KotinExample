package com.example.kotlinhelloworld.kotlin.chapter2

/**
 * Created by ManzarSiddique on 17-07-2017.
 */
class `1_3_Properties2` {

    class Person(
            val name: String,
            var isMarried: Boolean
    )

    fun main(args: Array<String>) {
        val person = Person("Bob", true)
        println(person.name)
        println(person.isMarried)
    }
}