package com.example.loginlogoutsharedpref

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val userNamePref = getSharedPreferences("username", Context.MODE_PRIVATE)
        val myName = userNamePref.getString("userLog", "")
        textView.text = "Hello $myName"

//        val userName = intent.getStringExtra("username")
//        textView.text = "Hello $userName"

        logout_btn.setOnClickListener()
        {

            val editor = userNamePref.edit()
            editor.putString("userLog", " ")
            editor.apply()

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}
