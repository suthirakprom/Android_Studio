package com.example.startforres

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun goHome(v: View)
    {
        var i = Intent()
        var username = editText.text.toString()
        var placeOfBirth = editText2.text.toString()

        //  we can't mix two value and expect it to show in two different components
        i.putExtra("Data", username)        //Data is one box for one value
        i.putExtra("Data1", placeOfBirth)   //Data1 is another box for one value
        setResult(Activity.RESULT_OK, i)
        finish()
    }

}
