package com.example.kotlinhelloworld.kotlin.program

/**
 * Created by ManzarSiddique on 26-07-2017.
 */
internal interface AnimalBase {
    val MAX_AGE: Int

    fun doMove(): String
    fun makeSound(): String
}

internal open class Dog(var petName: String = "", open protected val coat: String,
                        open protected val energy: Int) : AnimalBase {
    override val MAX_AGE = 15

    override fun doMove() = "Walks/runs"

    override fun makeSound() = "Woof!"

    fun stats() = "Coat: $coat, Energy: $energy"
}

internal open class SmallDog : Dog(coat = "Fluffy", energy = 10)

internal open class LargeDog : Dog(coat = "Shaggy", energy = 1)

internal class Chiwawa(petName: String) : SmallDog() {
    override fun makeSound() = "Yap, yap, yap!"

    init {
        this.petName = petName
    }
}

internal class GreatDane(petName: String) : LargeDog() {
    override val MAX_AGE = 12
    override val coat = "Smooth"

    init {
        this.petName = petName
    }
}

fun main(args: Array<String>) {
    val chiwawa = Chiwawa("Fifi")
    val greatDane = GreatDane("Charles")

    println("Chiwawa -  Name: ${chiwawa.petName}, Max Age: ${chiwawa.MAX_AGE}")
    println("Chiwawa Stats - ${chiwawa.stats()}")
    println("Chiwawa Sound - ${chiwawa.makeSound()}")
    println("Chiwawa Move - ${chiwawa.doMove()}")
    chiwawa.petName = "Nippy"
    println("Chiwawa's New Name - ${chiwawa.petName}\n")

    println("Great Dane: Name - ${greatDane.petName}, Max Age: ${greatDane.MAX_AGE}")
    println("Great Dane Stats - ${greatDane.stats()}")
    println("Great Dane Sound - ${greatDane.makeSound()}")
    println("Great Dane Move - ${greatDane.doMove()}")
}

//******************************************************************** My own example ************************************************************************//

open class A : C(), B {
    override fun test1() {
        test()
    }

    fun test(){
        println("Hello..!")
    }
}

open class C {

    open fun max() : String{
        println("Inside C")
        return "how"
    }
}

class D : A(){

    val x = C().max()

    override fun test1() {
//        super.test1()
        println("Inside D")
    }


}
interface B {
    fun test1()
}