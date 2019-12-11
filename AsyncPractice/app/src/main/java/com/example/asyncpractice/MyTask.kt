package com.example.asyncpractice

import android.content.Context
import android.os.AsyncTask
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.security.AccessControlContext

class MyTask(context: Context, button: Button, progressBar: ProgressBar, status:TextView):AsyncTask<Void, Int, String>() {

    lateinit var status: TextView
    lateinit var context: Context
    lateinit var progressBar: ProgressBar
    lateinit var button: Button

    init {
        this.context = context
        this.button = button
        this.status = status
        this.progressBar = progressBar
    }

    override fun onPreExecute() {                       // this is the must have function
        status.text = "Preparing download . . ."
        Thread.sleep(1000)
        button.isEnabled = false
    }
    override fun doInBackground(vararg p0: Void?): String {        // this is the must have function
        for(i in 1..100 step 1)
        {
            Thread.sleep(100)
            publishProgress(i)
        }
        return "Download Complete..."
    }

    override fun onProgressUpdate(vararg values: Int?) {        // this is the must have function
        super.onProgressUpdate(*values)
        var progress = values[0]
        progressBar.progress = progress!!
        status.text = "$progress % downloaded..."

    }

    override fun onPostExecute(result: String?) {           // this is the must have function
        super.onPostExecute(result)
        status.text = result
        button.isEnabled = true
    }

}