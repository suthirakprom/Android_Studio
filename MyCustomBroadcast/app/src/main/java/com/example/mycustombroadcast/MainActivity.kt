package com.example.mycustombroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var br:BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ifil = IntentFilter()
        ifil.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        ifil.addAction(Intent.ACTION_BATTERY_CHANGED)

        br = object:BroadcastReceiver()
        {
            override fun onReceive(p0: Context?, p1: Intent?) {
                Toast.makeText(this@MainActivity, p1?.action, Toast.LENGTH_LONG).show()
            }
        }

        registerReceiver(br,ifil)

    }

    override fun onDestroy() {
        unregisterReceiver(br)
        super.onDestroy()
    }
    
    fun sendBct(view: View)
    {
        var i = Intent(this,MyReceiver::class.java)
        sendBroadcast(i)
    }

}
