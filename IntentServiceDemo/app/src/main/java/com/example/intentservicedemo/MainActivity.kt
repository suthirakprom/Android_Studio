package com.example.intentservicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    lateinit var i:Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        i = Intent(this, MyService::class.java)
    }

    fun start(view: View)
    {
        startService(i)
    }
    fun stop(view: View)
    {
        stopService(i)
    }

}
