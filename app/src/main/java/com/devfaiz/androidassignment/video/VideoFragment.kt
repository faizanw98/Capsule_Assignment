package com.devfaiz.androidassignment.video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.devfaiz.androidassignment.R
import com.devfaiz.androidassignment.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {
    private lateinit var binding: FragmentVideoBinding
    private lateinit var viewModel: VideoFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_video, container, false)
        val application = requireNotNull(this.activity).application
        val player = binding.videoPlayer
        val viewModelFactory = VideoViewModelFactory(application)
        viewModel =ViewModelProvider(this,viewModelFactory)[VideoFragmentViewModel::class.java]
        binding.viewModel= viewModel
        viewModel.initializePlayer(player)
        binding.videoPlayer.player = viewModel.exoPlayer
        return binding.root
    }

    override fun onStop() {
        super.onStop()
        viewModel.releasePlayer()

    }

    override fun onDestroy() {
        viewModel.releasePlayer()
        super.onDestroy()
    }

    override fun onPause() {
        viewModel.releasePlayer()
        super.onPause()
    }
}