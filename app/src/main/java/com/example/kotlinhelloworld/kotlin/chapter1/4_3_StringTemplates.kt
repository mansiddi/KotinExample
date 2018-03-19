package com.example.kotlinhelloworld.kotlin.chapter1

/**
 * Created by ManzarSiddique on 17-07-2017.
 */
class `4_3_StringTemplates` {

    fun main(args: Array<String>){
        print("Hello ${if(args.size > 0) args[0] else "Someone!"}")
    }
}