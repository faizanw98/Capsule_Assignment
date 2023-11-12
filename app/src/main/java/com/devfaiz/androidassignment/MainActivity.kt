package com.devfaiz.androidassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.devfaiz.androidassignment.Notes.NotesFragment
import com.devfaiz.androidassignment.Quiz.QuizFragment
import com.devfaiz.androidassignment.Result.ResultFragment
import com.devfaiz.androidassignment.Video.VideoFragment
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