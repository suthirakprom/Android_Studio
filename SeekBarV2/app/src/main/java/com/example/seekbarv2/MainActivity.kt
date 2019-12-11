package com.example.seekbarv2

import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        alpha.max = 255
        red.max = 255
        green.max = 255
        blue.max = 255

        class CommonListener: SeekBar.OnSeekBarChangeListener {

            var al = 0
            var redCol = 0
            var greenCol = 0
            var blueCol = 0

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                when(p0?.id)
                {
                    R.id.alpha -> {
                        al = p1
                    }
                    R.id.red -> {
                        redCol = p1
                    }
                    R.id.green -> {
                        greenCol = p1
                    }
                    R.id.blue -> {
                        blueCol = p1
                    }
                }

                var myCol = Color.argb(al,redCol,greenCol,blueCol)
                textView.setBackgroundColor(myCol)
                button1.setOnClickListener {
                    button1.setBackgroundColor(myCol)
                }
                button2.setOnClickListener {
                    button2.setBackgroundColor(myCol)
                }
                button3.setOnClickListener {
                    button3.setBackgroundColor(myCol)
                }
                button4.setOnClickListener {
                    button4.setBackgroundColor(myCol)
                }


            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        }
        var commonListener = CommonListener()
        alpha.setOnSeekBarChangeListener(commonListener)
        red.setOnSeekBarChangeListener(commonListener)
        green.setOnSeekBarChangeListener(commonListener)
        blue.setOnSeekBarChangeListener(commonListener)
    }
}
