package com.example.sharedprefloginout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userPref = getSharedPreferences("userName", Context.MODE_PRIVATE)
        val passPref = getSharedPreferences("passWord", Context.MODE_PRIVATE)

        if(userPref.getString("userLog", "") != "")
        {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
            finish()
        }
        login_btn.setOnClickListener {
            val username = username.text.toString()
            val password = password.text.toString()

            val intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("username", username)
            intent.putExtra("password", password)

            val editor = userPref.edit()
            editor.putString("userLog", username)
            editor.apply()
            val editor1 = passPref.edit()
            editor1.putString("passLog", password)
            editor1.apply()
            startActivity(intent)

        }

    }
}
