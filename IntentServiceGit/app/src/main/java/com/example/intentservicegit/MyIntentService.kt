package com.example.intentservicegit

import android.app.IntentService
import android.content.Intent
import java.util.logging.Logger

class MyIntentService : IntentService("MyIntentService") {

    val log = Logger.getLogger(MyIntentService::class.java.name)

    override fun onHandleIntent(p0: Intent?) {
        if(p0 != null)
        {
            val data = p0.getStringExtra("data")
            log.info("Message is $data")
        }
    }


}