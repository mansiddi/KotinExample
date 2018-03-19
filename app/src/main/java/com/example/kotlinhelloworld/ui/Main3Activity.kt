package com.example.kotlinhelloworld.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlinhelloworld.R

class Main3Activity : AppCompatActivity()  {

    val TAG: String = "Main3Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }

    override fun onStart() {
        super.onStart()
        println(TAG + " : onStart")
    }

    override fun onStop() {
        super.onStop()
        println(TAG + " : onStop")
    }

    override fun onPause() {
        super.onPause()
        println(TAG + " : onPause")
    }

    override fun onResume() {
        super.onResume()
        println(TAG + " : onResume")
    }

    override fun onRestart() {
        super.onRestart()
        println(TAG + " : onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        println(TAG + " : onDestroy")
    }


    //An example of an if...else replacement for a ternary
    fun ternaryFunction(someValue: String): Int {
        return if (someValue.isEmpty()) 0 else 1
    }
}
