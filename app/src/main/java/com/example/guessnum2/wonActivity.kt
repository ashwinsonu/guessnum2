package com.example.guessnum2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class wonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_won)

        val number = intent.getStringExtra("Number")
        findViewById<TextView>(R.id.Number).text = "$number"

    }
}