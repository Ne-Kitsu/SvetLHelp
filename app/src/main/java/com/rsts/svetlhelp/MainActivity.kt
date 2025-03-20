package com.rsts.svetlhelp

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge


class MainActivity : ComponentActivity() {
    private lateinit var videoView: VideoView
    private val packageName: String = "com.rsts.svetlhelp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        videoView = findViewById(R.id.videoView)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        val videoUrl: String = "android.resource://" + packageName + "/" + R.raw.session_369
        val uri = Uri.parse(videoUrl)
        videoView.setVideoURI(uri)
        videoView.start()
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true
        }
        videoView.setOnCompletionListener {
        }
    }
}
