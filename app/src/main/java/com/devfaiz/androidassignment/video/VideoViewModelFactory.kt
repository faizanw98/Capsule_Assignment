package com.devfaiz.androidassignment.video

import android.app.Application
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.media3.ui.PlayerView

class VideoViewModelFactory(private val application: Application):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VideoFragmentViewModel::class.java)){
            return VideoFragmentViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}