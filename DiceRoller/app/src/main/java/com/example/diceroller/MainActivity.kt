package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

/*
AppCompatActivity is a subclass of Activity that supports all modern Android features
while providing backward compatibility with older versions of Android. To make your app
available to the largest number of devices and users possible, always use AppCompatActivity
 */

class MainActivity : AppCompatActivity() {
    //    Ideally, you should minimize the number of calls to findViewById(), because the Android
//    system is searching the entire view hierarchy each time, and that's an expensive operation.
//    It is a best practice to use lateinit with fields that hold views in just this way.
//    The lateinit keyword promises the Kotlin compiler that the variable will be initialized
//    before the code calls any operations on it.
    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView

    //    Activities do not use a constructor to initialize the object.
//    Instead, a series of predefined methods (called "lifecycle methods")
//    are called as part of the activity setup.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Resources do not include file extensions.
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    private fun getRandomDiceImage(): Int {

        return when (Random.nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
