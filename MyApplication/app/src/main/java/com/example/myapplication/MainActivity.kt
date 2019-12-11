package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun result(view: View)
    {
        val intent = Intent(this, Main2Activity::class.java)
        val firstNum = editText2.text.toString()
        val secondNum = editText4.text.toString()
        intent.putExtra("Number1", firstNum)
        intent.putExtra("Number2", secondNum)
        startActivity(intent)
    }
}
