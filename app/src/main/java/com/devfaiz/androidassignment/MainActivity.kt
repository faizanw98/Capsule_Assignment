package com.devfaiz.androidassignment

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import androidx.viewpager2.widget.ViewPager2.SCROLL_STATE_DRAGGING
import com.devfaiz.androidassignment.notes.NotesFragment
import com.devfaiz.androidassignment.quiz.QuizFragment
import com.devfaiz.androidassignment.result.ResultFragment
import com.devfaiz.androidassignment.video.VideoFragment
import com.devfaiz.androidassignment.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val frags = arrayListOf("Video","Notes","Quiz","Result")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val fragmentList = arrayListOf(
            VideoFragment(),
            NotesFragment(),
            QuizFragment(),
            ResultFragment())
        val viewPager = binding.viewPager
        val tabView = binding.tabLayout
        val adapter =ViewPagerAdapter(supportFragmentManager,
            fragmentList,
            lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabView,viewPager){tab,position->
            tab.text = frags[position]
        }.attach()
        
        setContentView(binding.root)
    }
}