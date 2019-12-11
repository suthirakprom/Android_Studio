package com.example.sharedprefdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pref = MyPref(this@MainActivity)

        var currrentScore = pref.getScore()
        score.text = "Your score is $currrentScore"

        currrentScore++

        pref.setScore(currrentScore)
    }
}
