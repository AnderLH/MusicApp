package com.example.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private var bottonpressed: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play: ImageButton = findViewById<ImageButton>(R.id.imageButtonPlay)
        val pause: ImageButton = findViewById<ImageButton>(R.id.imageButtonPause)

        play.setOnClickListener {
            play.visibility = View.INVISIBLE
            pause.visibility = View.VISIBLE
            bottonpressed = true
        }

        pause.setOnClickListener {
            pause.visibility = View.INVISIBLE
            play.visibility = View.VISIBLE
            bottonpressed = false
        }

    }

    override fun onResume() {
        super.onResume()
        val play : ImageView = findViewById<ImageView>(R.id.imageButtonPlay)
        val pause : ImageView = findViewById<ImageView>(R.id.imageButtonPause)
        if (bottonpressed) {
            pause.visibility = View.VISIBLE
            play.visibility = View.INVISIBLE
        }else {
            pause.visibility = View.INVISIBLE
            play.visibility = View.VISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save the user's current game state.
        outState?.run {
            putBoolean("result", bottonpressed)
        }
        // Always call the superclass so it can save the view hierarchy.
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Always call the superclass so it can restore the view hierarchy.
        super.onRestoreInstanceState(savedInstanceState)
        // Restore state members from saved instance.
        savedInstanceState?.run {
            bottonpressed = savedInstanceState.getBoolean("result")
            val play : ImageView = findViewById<ImageView>(R.id.imageButtonPlay)
            val pause : ImageView = findViewById<ImageView>(R.id.imageButtonPause)
            if(bottonpressed) {
                pause.visibility = View.VISIBLE
                play.visibility = View.INVISIBLE
            }else {
                pause.visibility = View.INVISIBLE
                play.visibility = View.VISIBLE
            }
        }
    }
}