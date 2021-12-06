package com.example.guessnum2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import java.util.*
import kotlin.random.Random

var attempt = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var randNumber = Random.nextInt(0, 1000)
        val guessMsg = findViewById<TextView>(R.id.AnswerText)
        val stillMsg = findViewById<TextView>(R.id.FoundSol)

        findViewById<TextView>(R.id.GuessButton).setOnClickListener {
            val guessInput = findViewById<TextInputLayout>(R.id.InputNumber)
            val guessNumber = guessInput.editText?.text?.toString()?.toInt()
            when {
                attempt <= 12 && guessNumber == 0 -> {
                    guessMsg.text = "Enter A Valid Number"
                    stillMsg.text = "you haven't yet found the solution"
                    attempt++
                }
                attempt <= 12 && randNumber > guessNumber!! -> {
                    guessMsg.text = "no :( My Number Is Bigger"
                    stillMsg.text = "you haven't yet found the solution"
                    attempt++
                }
                attempt <= 12 && randNumber < guessNumber!! -> {
                    guessMsg.text = "no :( My Number Is Smaller"
                    stillMsg.text = "you haven't yet found the solution"
                    attempt++
                }
                attempt <= 12 && randNumber == guessNumber!! -> {
                    val newScreenIntent = Intent(this, wonActivity::class.java)
                    newScreenIntent.putExtra("Number", "$randNumber")
                    startActivity(newScreenIntent)
                    randNumber = Random.nextInt(0, 1000)
                    attempt = 0
                    guessMsg.text=""
                    stillMsg.text=""
                }
                attempt > 12 -> {
                    val newScreenIntent = Intent(this, EndActivity::class.java)
                    newScreenIntent.putExtra("Number", "$randNumber")
                    startActivity(newScreenIntent)
                    randNumber = Random.nextInt(0, 1000)
                    attempt = 0
                    guessMsg.text=""
                    stillMsg.text=""

                }
            }
        }
    }
}
