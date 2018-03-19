package com.example.kotlinhelloworld.kotlin.chapter1

/**
 * Created by ManzarSiddique on 17-07-2017.
 */
class `4_2_StringTemplates` {

    fun main(args: Array<String>){
        if (args.size > 0){
            print("Hello ${args[0]}!")
        }
    }
}