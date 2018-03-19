package com.example.kotlinhelloworld.kotlin.program
/**
 * Created by ManzarSiddique on 18-07-2017.
 */


fun main(a: Array<String>) {
    findDuplicateChars("Manzar")
}
fun findDuplicateChars(str: String) {

    val dupMap = HashMap<Char, Int>()
    val chrs = str.toCharArray()
    for (ch in chrs) {
        if (dupMap.containsKey(ch)) {
            dupMap.put(ch, dupMap[ch]!! + 1)
        } else {
            dupMap.put(ch, 1)
        }
    }
    val keys = dupMap.keys
    for (ch in keys) {
        if (dupMap[ch]!! > 1) {
            println(ch + "--->" + dupMap[ch])
        }
    }
}