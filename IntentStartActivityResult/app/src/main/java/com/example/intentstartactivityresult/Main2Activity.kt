package com.example.intentstartactivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val Num1 = intent.getStringExtra("Num1")
        val Num2 = intent.getStringExtra("Num2")

        textView2.text = "First Number: $Num1"
        textView3.text = "Second Number: $Num2"

        button2.setOnClickListener {
            val i = Intent()
            val result = Num1.toInt() + Num2.toInt()
            i.putExtra("Res", result.toString())
            setResult(Activity.RESULT_OK, i)
            finish()
        }
    }
}
