package com.example.intentstartactivityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val num1 = editText1.text.toString()
            val num2 = editText2.text.toString()
            val intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("Num1", num1)
            intent.putExtra("Num2", num2)
            startActivityForResult(intent, 2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 2)
        {
            var str:String? = data?.getStringExtra("Res")
            answer.text = "The answer is $str"
        }
    }
}
