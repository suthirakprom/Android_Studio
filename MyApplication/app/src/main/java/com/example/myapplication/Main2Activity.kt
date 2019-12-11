package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val Num1 = intent.getStringExtra("Number1")
        val Num2 = intent.getStringExtra("Number2")
        var res = Num1.toInt() + Num2.toInt()
        showResult.text = res.toString()
    }


}
