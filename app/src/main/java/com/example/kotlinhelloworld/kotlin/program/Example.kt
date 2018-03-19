package com.example.kotlinhelloworld.kotlin.program

/**
 * Created by ManzarSiddique on 25-07-2017.
 */

 fun main(args: Array<String>){
    val temp = arrayOf("ManzarHussain,1,5", "SiddiqueManzar,2,6", "HussainSiddique,3,7")
    example(temp)
}
 fun example(arr: Array<String>) {
    var concatenate = ""
    for (i in arr.indices) {
        val extract = arr[i]
        val temp = extract.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//        val temp = extract.split(",")
        val data = temp[0]
        val start = Integer.parseInt(temp[1])
        val end = Integer.parseInt(temp[2])

        val lastIndex = start + end + 1

//        if (i == arr.size - 1) concatenate = concatenate + data.substring(start, lastIndex) else concatenate = concatenate + data.substring(start, lastIndex) + Character.toString(1.toChar())
        if (i == arr.size - 1) {
            concatenate = concatenate + data.substring(start, lastIndex)
        } else {
            concatenate = concatenate + data.substring(start, lastIndex) + Character.toString(1.toChar())
        }
    }
    println("Result Temp data : " + " :::::: " + concatenate)
}