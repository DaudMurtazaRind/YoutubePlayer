package com.example.youtubeplayer

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.View.GONE
import android.widget.LinearLayout
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.youtubeplayer.databinding.ActivityMainBinding
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView


class MainActivity : YouTubeBaseActivity(), YouTubePlayer.PlaybackEventListener,
    YouTubePlayer.OnInitializedListener {

    val key = "AIzaSyCNp6DJECgHJcVMj_0yQQh6frVkR8mfyN8"
    var stoppedCount = 0
    lateinit var binding: ActivityMainBinding
    lateinit var player: YouTubePlayerView
    var p1: YouTubePlayer? = null
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        player = findViewById(R.id.player)

        binding.play.setOnClickListener {
            player.initialize(key, this)
        }
    }


//override fun onFullscreen(p0: Boolean) {
//    this@MainActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//    binding.play.visibility = GONE
//    player.layoutParams = ConstraintLayout.LayoutParams(
//        LinearLayout.LayoutParams.WRAP_CONTENT,
//        LinearLayout.LayoutParams.WRAP_CONTENT
//    )
//}

    override fun onPlaying() {
//        Toast.makeText(this@MainActivity, "", LENGTH_SHORT).show()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onPaused() {
//        Toast.makeText(this@MainActivity, "your video is paused", LENGTH_SHORT).show()
        i = p1?.currentTimeMillis!!
        Toast.makeText(this@MainActivity, "your current time is $i", LENGTH_SHORT).show()
        if (isInPictureInPictureMode) {

        }
    }

    override fun onStopped() {
        stoppedCount += 1
        if (stoppedCount > 1) {
            Toast.makeText(this@MainActivity, "your video is stopped", LENGTH_SHORT).show()
        }
    }

    override fun onBuffering(p0: Boolean) {
        Toast.makeText(this@MainActivity, "your video is buffering", LENGTH_SHORT).show()
    }

    override fun onSeekTo(p0: Int) {
        Toast.makeText(this@MainActivity, "", LENGTH_SHORT).show()
    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {

        p1?.loadVideo("1uwvxTT5V5M")
        if (p1 != null) {
            p1.play()
        }
        p1?.setPlaybackEventListener(this)
        this.p1 = p1
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {

    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onPause() {
        super.onPause()
        //i = p1?.currentTimeMillis!!
        this?.enterPictureInPictureMode()
    }

    override fun onPictureInPictureModeChanged(
        isInPictureInPictureMode: Boolean,
        newConfig: Configuration
    ) {
        if (isInPictureInPictureMode) {
//            p1?.loadVideo("1uwvxTT5V5M")
//            Thread.sleep(1000)
//            p1?.seekToMillis(i)
//            p1?.play()


        } else {
            // Restore the full-screen UI.
        }
    }
}

//1uwvxTT5V5M
