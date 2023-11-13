package com.devfaiz.androidassignment.video

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.media3.common.MimeTypes
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.dash.DashMediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView

class VideoFragmentViewModel(application: Application): AndroidViewModel(application) {
    private lateinit var playerView: PlayerView
    var exoPlayer: ExoPlayer? =null
    private var playBackPosition = 0L
    private val context= getApplication<Application>().applicationContext
    var playWhenReady = true
    @SuppressLint("UnsafeOptInUsageError")
     fun initializePlayer(view: PlayerView) {
        playerView = view
        exoPlayer = ExoPlayer.Builder(context).build()
        exoPlayer?.playWhenReady = true
        val defaultHttpDataSourceFactory = DefaultHttpDataSource.Factory()
        val mediaItem = androidx.media3.common.MediaItem.Builder()
            .setUri(URL)
            .setMediaId(MimeTypes.APPLICATION_MP4)
            .build()
        val mediaSource = ProgressiveMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(mediaItem)
        exoPlayer?.setMediaSource(mediaSource)
        exoPlayer?.seekTo(playBackPosition)
        exoPlayer?.playWhenReady = playWhenReady
        exoPlayer?.prepare()
        exoPlayer?.play()

    }
    fun releasePlayer(){
        exoPlayer?.let {player->
            playBackPosition = player.currentPosition
            playWhenReady = player.playWhenReady
            player.release()
            exoPlayer = null
        }
    }
    companion object{
        const val URL ="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4"
    }
}