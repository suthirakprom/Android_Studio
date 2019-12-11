package com.example.boundservice

import  android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import android.os.IBinder
import java.util.*

class MyService : Service() {

    inner class MyBinder:Binder()
    {
        fun getObject():MyService{
            return this@MyService
        }
    }

    var binder:Binder = MyBinder()

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    fun getTime():String {
        return Date().toString()
    }
}
