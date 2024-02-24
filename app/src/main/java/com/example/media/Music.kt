package com.example.media

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.SeekBar

class Music : AppCompatActivity() {
    lateinit var runnable: Runnable
    private var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        val mediaplayer = MediaPlayer.create(this, R.raw.uncoco)
        val seekbar = findViewById<SeekBar>(R.id.seekbar)
        val btnPlay = findViewById<ImageButton>(R.id.btn_play)

        seekbar.progress = 0
        seekbar.max = mediaplayer.duration

        btnPlay.setOnClickListener{
            if(!mediaplayer.isPlaying) {
                mediaplayer.start()
                btnPlay.setImageResource(R.drawable.baseline_pause_24)
            }
            else {
                mediaplayer.pause()
                btnPlay.setImageResource(R.drawable.baseline_play_arrow_24)
            }
        }

        seekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaplayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        runnable = Runnable {
            seekbar.progress = mediaplayer.currentPosition
            handler.postDelayed(runnable, 1000)
        }

        handler.postDelayed(runnable, 1000)

        mediaplayer.setOnCompletionListener {
            btnPlay.setImageResource(R.drawable.baseline_play_arrow_24)
            seekbar.progress = 0
        }
    }
}