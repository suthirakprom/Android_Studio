package com.example.intentservicedemo

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.MediaStore
import android.widget.Toast

class MyService : IntentService("Daemon . . .") {       //  using this we can have as many thread as we want
    var player:MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer.create(this, R.raw.leaktuk)
    }
    override fun onHandleIntent(p0: Intent?) {
        player?.start()
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()      //  the Toast message is not showing
        Thread.sleep(10000)                                                             //   and we don't know why
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show()      //  the Toast message is not showing
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {     //these lines of code is only used in a single thread
//        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()            //  or multi thread
//        Thread.sleep(5000)
//        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show()
//        return super.onStartCommand(intent, flags, startId)
//    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Service Killed", Toast.LENGTH_SHORT).show()
        player?.stop()

    }

}
