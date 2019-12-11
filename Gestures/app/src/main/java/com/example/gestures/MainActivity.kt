package com.example.gestures

import android.gesture.Gesture
import android.graphics.Color
import android.graphics.ColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener
{
    
    var gdc:GestureDetectorCompat? = null

    override fun onShowPress(p0: MotionEvent?) {
        textView.text = "Show press . . ."
        page.setBackgroundColor(Color.BLUE)
    }

    override fun onLongPress(p0: MotionEvent?) {
        textView.text = "Long press . . ."
        page.setBackgroundColor(Color.GREEN)
    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        textView.text = "Tap up . . ."
        page.setBackgroundColor(Color.GREEN)
        return true
    }
    override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onDoubleTap(p0: MotionEvent?): Boolean {
        textView.text = "Double tap . . ."
        page.setBackgroundColor(Color.LTGRAY)
        return true
    }

    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
        textView.text = "Double tap . . ."
        page.setBackgroundColor(Color.MAGENTA)
        return true
    }
    override fun onDown(p0: MotionEvent?): Boolean {
        textView.text = "Key down . . ."
        page.setBackgroundColor(Color.YELLOW)
        return true
    }

    override fun onFling(downEvent: MotionEvent, moveEvent: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        textView.text = "Flinging . . ."
        page.setBackgroundColor(Color.GRAY)
        return true
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        textView.text = "Scrolling . . ."
        page.setBackgroundColor(Color.DKGRAY)
        return true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gdc?.onTouchEvent(event)
        return super.onTouchEvent(event)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gdc = GestureDetectorCompat(this, this)
        gdc?.setOnDoubleTapListener(this)
    }
}
