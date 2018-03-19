package com.example.kotlinhelloworld.kotlin

/**
 * Created by ManzarSiddique on 17-07-2017.
 */

    data class Person(val name: String,
                      val age: Int? = null)

    fun main(args: Array<String>) {
        val persons = listOf(Person("Alice"),
                Person("Bob", age = 29))

        val oldest = persons.maxBy { it.age ?: 0 }
        println("The oldest is: $oldest")
    }

// The oldest is: Person(name=Bob, age=29)
