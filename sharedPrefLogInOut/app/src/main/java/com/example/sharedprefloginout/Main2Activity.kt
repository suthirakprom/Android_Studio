package com.example.sharedprefloginout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val userPref = getSharedPreferences("username", Context.MODE_PRIVATE)
        val myname = userPref.getString("userLog", "")
        result.text = "Welcome $myname"

        logout_btn.setOnClickListener {
            val editor = userPref.edit()
            editor.putString("userLog", "")
            editor.apply()

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }

    }
}
