package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.random.Random

/*
AppCompatActivity is a subclass of Activity that supports all modern Android features
while providing backward compatibility with older versions of Android. To make your app
available to the largest number of devices and users possible, always use AppCompatActivity
 */

class MainActivity : AppCompatActivity() {
    //  Activities do not use a constructor to initialize the object.
    // Instead, a series of predefined methods (called "lifecycle methods")
    // are called as part of the activity setup.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Resources do not include file extensions.
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton: Button = findViewById(R.id.countUp_button)
        countUpButton.setOnClickListener { countUp() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }

    private fun rollDice() {
//        Toast.makeText(this, "button clicked",
//            Toast.LENGTH_SHORT).show()
        val randomInt = Random.nextInt(6) + 1

        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = when(resultText.text.toString()) {
            // If the text is the default "Hello World!", set that text to 1
            "Hello World!" -> "1"
            // If the number is already 6, do nothing
            "6" -> "6"
            // Otherwise, add 1 to it
            else -> (resultText.text.toString().toInt() + 1).toString()
        }
    }

    private fun reset() {
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "1"
    }
}
