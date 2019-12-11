package com.example.sqlexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if(editText.text.toString().length > 0 && editText2.text.toString().length>0) {
                var user = User(editText.text.toString(), editText2.text.toString().toInt())
                var db = DataBaseHandler(this)
                db.insertData(user)
            } else {
                Toast.makeText(this, "Please fill all the data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
