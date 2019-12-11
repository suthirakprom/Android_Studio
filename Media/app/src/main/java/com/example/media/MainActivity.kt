package com.example.media

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var mediaPlayer: MediaPlayer
    private var durations = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.leaktuk)
        mediaPlayer.setVolume(0.5f,0.5f)
        durations = mediaPlayer.duration

        duration.setOnSeekBarChangeListener (
            object : SeekBar.OnSeekBarChangeListener
            {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    if(p2)
                    {
                        var vol = p1/100.0f
                        mediaPlayer.setVolume(vol,vol)
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {}

                override fun onStopTrackingTouch(p0: SeekBar?) {}

            }
        )

        duration.max = durations
        duration.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    if(p2)
                    {
                        mediaPlayer.seekTo(p1)
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {}

                override fun onStopTrackingTouch(p0: SeekBar?) {}

            }
        )



        var handler = @SuppressLint("HandlerLeak")
        object : Handler()
        {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                var currentP = msg.what
                duration.progress = currentP


                var timeN = createTime(currentP)
                time.text = timeN

                var timeN1 = createTime(durations - currentP)
                time1.text = "-$timeN1"
            }
        }


    }

    private fun createTime(timeN: Int):String
    {
        var tm = ""
        var mt = timeN/1000/60
        var sec = timeN/1000%60

        tm = "$mt"
        if(sec<10) tm+="0"
        tm+=sec
        return tm
    }

    fun play(view: View)
    {
        if(mediaPlayer.isPlaying)
        {
            mediaPlayer.pause()
        }
        else
        {
            mediaPlayer.start()
        }
    }

}
