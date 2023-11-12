package com.devfaiz.androidassignment.Quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.devfaiz.androidassignment.R
import com.devfaiz.androidassignment.databinding.FragmentQuizBinding
import com.devfaiz.androidassignment.databinding.FragmentResultBinding


class QuizFragment : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_quiz, container, false)
        return binding.root
    }

}