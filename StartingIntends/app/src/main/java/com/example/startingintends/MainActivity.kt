package com.example.startingintends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun startNewActivity(v:View)
    {
        var intent = Intent(this, Main2Activity::class.java)

//        intent.putExtra("names", "Jin")
//        intent.putExtra("school","KIT")

        var bundle = Bundle()

        bundle.putString("name", "Jin Jason")
        bundle.putString("School", "KIT")

        intent.putExtras(bundle)

        startActivity(intent)
    }
}
