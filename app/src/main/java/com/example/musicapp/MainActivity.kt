package com.example.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPlay: ImageButton = findViewById<ImageButton>(R.id.imageButtonPlay)
        val buttonPause: ImageButton = findViewById<ImageButton>(R.id.imageButtonPause)


        buttonPlay.setOnClickListener {
            buttonPlay.visibility = View.INVISIBLE
            buttonPause.visibility = View.VISIBLE
        }

        buttonPause.setOnClickListener {
            buttonPause.visibility = View.INVISIBLE
            buttonPlay.visibility = View.VISIBLE
        }

    }
}