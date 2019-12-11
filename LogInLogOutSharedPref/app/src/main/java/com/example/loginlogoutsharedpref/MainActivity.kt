package com.example.loginlogoutsharedpref

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernamePref = getSharedPreferences("userName", Context.MODE_PRIVATE)
        val passwordPref = getSharedPreferences("passWord", Context.MODE_PRIVATE)

        if(usernamePref.getString("userLog", "") != " ")
        {
            val intent = Intent(this, Main2Activity::class.java)
            startService(intent)
            finish()
        }

        login_btn.setOnClickListener {
            val username = editText.text.toString()
            val password = editText2.text.toString()

            val intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("username", username)
            intent.putExtra("password", password)

            val editor = usernamePref.edit()
            editor.putString("userLog", username)
            editor.apply()
            val editor1 = passwordPref.edit()
            editor1.putString("passLog", password)
            editor1.apply()
            startActivity(intent)
        }

    }
}
