package com.example.media

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val musicActivity = findViewById<Button>(R.id.btn_music)
        val videoActivity = findViewById<Button>(R.id.btn_video)

        musicActivity.setOnClickListener {
            val intent = Intent(this, Music::class.java)
            startActivity(intent)
        }

        videoActivity.setOnClickListener {
            val intent = Intent(this, Video::class.java)
            startActivity(intent)
        }
    }
}