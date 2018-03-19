package com.example.kotlinhelloworld.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.kotlinhelloworld.R

class MainActivity : AppCompatActivity() {

    val TAG: String = "MainActivity"
//    val TAG = MainActivity::class.simpleName
//    val TAG = MainActivity::class.java!!.getName()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show()
        }*/
        fab.setOnClickListener { v ->
            Toast.makeText(this, "hello : " + String.format(getString(R.string.test), "28", "Manzar"), Toast.LENGTH_LONG).show()
            val intent: Intent = Intent(this, Main3Activity::class.java);
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    // Return null if str does not hold a number
    fun parseInt(str: String): Int? {
        try {
            return str.toInt()
        } catch (e: NumberFormatException) {
            println("One of the arguments isn't Int")
        }
        return null
    }

    fun main(args: Array<String>) {
        if (args.size < 2) {
            println("No number supplied");
        } else {
            val x = parseInt(args[0])
            val y = parseInt(args[1])

            // We cannot say 'x * y' now because they may hold nulls
            if (x != null && y != null) {
                print(x * y) // Now we can
            } else {
                println("One of the arguments is null")
            }
        }
    }

    override fun onStart() {
        super.onStart()
//        Log.d(TAG, "onStart");
//        print(TAG + " : onStart")
        println(TAG + " : onStart")
    }

    override fun onStop() {
        super.onStop()
//        Log.d(TAG, "onStop");
//        print(TAG + " : onStop")
        println(TAG + " : onStop")
    }

    override fun onPause() {
        super.onPause()
//        Log.d(TAG, "onPause");
//        print(TAG + " : onPause")
        println(TAG + " : onPause")
    }

    override fun onResume() {
        super.onResume()
//        Log.d(TAG, "onResume");
//        print(TAG + " : onResume")
        println(TAG + " : onResume")
    }

    override fun onRestart() {
        super.onRestart()
//        print(TAG + " : onRestart")
        println(TAG + " : onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
//        Log.d(TAG, "onDestroy");
//        print(TAG + " : onDestroy")
        println(TAG + " : onDestroy")
    }
}
