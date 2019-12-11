package com.example.checkboxcheck

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var order:String = ""
        getSelection.setOnClickListener {
            order=""
            if(pizza.isChecked)
            {
                order+="Pizza is selected . . ."
            }
            if(donut.isChecked)
            {
                order+="Donut is selected . . ."
            }
            if (candy.isChecked)
            {
                order+="Candy is selected . . ."
            }
            Toast.makeText(this, order, Toast.LENGTH_SHORT).show()
        }

    }
}
