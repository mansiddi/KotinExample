package com.example.kotlinhelloworld.kotlin.program

/**
 * Created by ManzarSiddique on 18-07-2017.
 */

fun main(args: Array<String>){
    println("Reverse is : "+reverse(43553))

    val list = listOf(20, 34, 21, 87, 92,99)
    val array = arrayOf(22, 33, 221, 83217, 9112,199)
    topTwoFromList(list)
    topTwoFromArray(array)
}

fun reverse(number: Int): Int{
    var input: Int = number
    var num: Int = 0

    while (input != 0){
        num = (num*10)+(input%10)
        input = input/10
    }
    return num;
}

fun topTwoFromList(list: List<Int>){
    var max1: Int = 0
    var max2: Int = 0

    for (number in list) {

        if (number > max1) {
            max2 = max1
            max1 = number
        } else if (number > max2){
            max2 = number
        }
    }

    println("Given integer list : " +list);
    println("First maximum number is : " + max1);
    println("Second maximum number is : " + max2);
}

fun topTwoFromArray(array: Array<Int>){
    var max1: Int = 0
    var max2: Int = 0
    for (number in array) {
        if (number > max1) {
            max2 = max1
            max1 = number
        } else if (number > max2){
            max2 = number
        }
    }
    println("Given integer array : " +array);
    println("First maximum number is : " + max1);
    println("Second maximum number is : " + max2);
}

/*public class NumberReverse {

    public int reverseNumber(int number){

        int reverse = 0;
        while(number != 0){
            reverse = (reverse*10)+(number%10);
            number = number/10;
        }
        return reverse;
    }

    public static void main(String a[]){
        NumberReverse nr = new NumberReverse();
        System.out.println("Result: "+nr.reverseNumber(17868));
    }
}*/
