package com.example.clickcounter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textView : TextView
    lateinit var buttonUp : Button
    lateinit var buttonDown : Button
    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Init()

        buttonUp.setOnClickListener{
            num++
            textView.setText(num.toString())
            if (num == 0) {
                textView.setTextColor(Color.rgb(0, 0, 255))
            }
            else if (num > 0) {
                textView.setTextColor(Color.rgb(0, 255, 0))
            }
        }

        buttonDown.setOnClickListener{
            num--
            textView.setText(num.toString())
            if (num == 0) {
                textView.setTextColor(Color.rgb(0, 0, 255))
            }
            else if (num < 0) {
                textView.setTextColor(Color.rgb(255, 0, 0))
            }
        }
    }

    fun Init()
    {
        textView = findViewById(R.id.tv_num)
        textView.setText(num.toString())
        buttonUp = findViewById(R.id.btn_top)
        buttonDown = findViewById(R.id.btn_bottom)
    }

}