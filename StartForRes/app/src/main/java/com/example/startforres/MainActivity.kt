package com.example.startforres

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

    fun callB(v: View)
    {
        var i = Intent(this, Main2Activity::class.java)
        startActivityForResult(i, 12)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==12)
        {
            var str = data?.getStringExtra("Data")
            var str1 = data?.getStringExtra("Data1")
            user.text = str
            city.text = str1
        }
    }

}
