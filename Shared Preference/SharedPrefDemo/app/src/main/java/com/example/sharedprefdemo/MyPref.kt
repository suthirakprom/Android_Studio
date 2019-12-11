package com.example.sharedprefdemo

import android.content.Context

class MyPref(context: Context)
{
    val SCORE = "myscore"
    val MY_PREF = "mypref"
    val pref = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE)

    fun getScore():Int
    {
        var score = pref.getInt(SCORE, 0)
        return score
    }

    fun setScore(score:Int)
    {
        var editor = pref.edit()
        editor.putInt(SCORE,score)
        editor.apply()
    }



}