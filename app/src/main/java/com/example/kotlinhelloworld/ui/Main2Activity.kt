package com.example.kotlinhelloworld.ui

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlinhelloworld.R

//Inheritance and interface implementation
class Main2Activity : AppCompatActivity(), DialogInterface.OnClickListener {
    override fun onClick(dialog: DialogInterface?, which: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}
