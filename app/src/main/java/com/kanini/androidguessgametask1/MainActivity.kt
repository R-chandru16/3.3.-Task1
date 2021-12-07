package com.kanini.androidguessgametask1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
// num from 0 to 1000
    var num = (0..1000).random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numInputView = findViewById<TextInputLayout>(R.id.inputNumber)
        val checkButtonView = findViewById<TextView>(R.id.checkButton)
        val resultView = findViewById<TextView>(R.id.result)

        checkButtonView.setOnClickListener{
            val number = numInputView.editText?.text?.toString()
            val myguessedNumber =
                if (number.isNullOrEmpty()) "0"
                else number
            if (myguessedNumber != "0") {
                if (myguessedNumber.toInt() == num)
                    resultView.text = "success You are right!"
                else if(myguessedNumber.toInt() > num)
                    resultView.text = "No:) My number is smaller"
                else
                    resultView.text = "No:) My number is bigger"
            }
            else
                resultView.text = "please enter the number between 0 to 1000"
        }
    }
}