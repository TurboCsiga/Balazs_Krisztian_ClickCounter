package com.example.clickcounter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
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
            if (checkIfPrime(num)) {
                textView.setTextColor(Color.rgb(255, 255, 255))
            }
            else if (num == 0) {
                textView.setTextColor(Color.rgb(0, 0, 255))
            }
            else if (num > 0) {
                textView.setTextColor(Color.rgb(0, 255, 0))
            }
            else if (num < 0) {
                textView.setTextColor(Color.rgb(255, 0, 0))
            }
        }

        buttonDown.setOnClickListener{
            num--
            textView.setText(num.toString())
            if (checkIfPrime(num)) {
                textView.setTextColor(Color.rgb(255, 255, 255))
            }
            else if (num == 0) {
                textView.setTextColor(Color.rgb(0, 0, 255))
            }
            else if (num < 0) {
                textView.setTextColor(Color.rgb(255, 0, 0))
            }
            else if (num > 0) {
                textView.setTextColor(Color.rgb(0, 255, 0))
            }
        }

        textView.setOnLongClickListener {
            num = 0
            textView.setText(num.toString())
            textView.setTextColor(Color.rgb(0, 0, 255))
            return@setOnLongClickListener true
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val useNum = num
        outState.putInt("savedInt", num)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val userInt = savedInstanceState.getInt("savedInt", 0)
        num  = userInt
        textView.text = num.toString()
    }

    fun checkIfPrime(szam: Int): Boolean {
        if (szam < 2) return false
        else if (num < 4) return true
        var i = szam - 1
        var search = true
        while (i >= Math.floor(Math.sqrt(szam.toDouble())) && search) {
            if (szam % i == 0) search = false
            i--
        }
        return search
    }

    fun Init()
    {
        textView = findViewById(R.id.tv_num)
        textView.setText(num.toString())
        buttonUp = findViewById(R.id.btn_top)
        buttonDown = findViewById(R.id.btn_bottom)
    }

}