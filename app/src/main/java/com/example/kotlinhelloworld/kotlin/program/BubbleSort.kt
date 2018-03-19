package com.example.kotlinhelloworld.kotlin.program

import java.util.*

/**
 * Created by ManzarSiddique on 18-07-2017.
 */

            /* All for loop in kotlin as rangs
            *
            *
            for (i in 1..100) { ... }  // closed range: includes 100
            for (i in 1 until 100) { ... } // half-open range: does not include 100
            for (x in 2..10 step 2) { ... }
            for (x in 10 downTo 1) { ... }
            if (x in 1..10) { ... }
            *
            *
            * */

            fun main(args: Array<String>) {
                val list = arrayOf(4, 9, 2, 6, 23, 12, 34, 0, 1)
                bubbleSort(list)
            //    println()
            }

            fun bubbleSort(array: Array<Int>) {
                var n = array.size - 1
                var k: Int

                //Reverse loop, iterate till 0th index
                for (m in n downTo 0) {
                    //Normal for loop 0 to n-1
                    for (i in 0..n - 1) {
                        k = i + 1
                        if (array[i] > array[k]) {
                            swap(i, k, array)
                        }
                    }

                    println(Arrays.toString(array))
                }
            }

            fun swap(i: Int, j: Int, array: Array<Int>) {
            //    println("i : "+i + " j :"+j)
                var temp: Int
                temp = array[i]
                array[i] = array[j]
                array[j] = temp
            }

            /*// logic to sort the elements
                public static void bubble_srt(int array[]) {
                    int n = array.length;
                    int k;
                    for (int m = n; m >= 0; m--) {
                        for (int i = 0; i < n - 1; i++) {
                            k = i + 1;
                            if (array[i] > array[k]) {
                                swapNumbers(i, k, array);
                            }
                        }
                        printNumbers(array);
                    }
                }

                private static void swapNumbers(int i, int j, int[] array) {

                    int temp;
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }

                private static void printNumbers(int[] input) {

                    for (int i = 0; i < input.length; i++) {
                        System.out.print(input[i] + ", ");
                    }
                    System.out.println("\n");
                }

                public static void main(String[] args) {
                    int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
                    bubble_srt(input);

                }*/