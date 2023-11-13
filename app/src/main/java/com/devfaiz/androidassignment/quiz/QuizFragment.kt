package com.devfaiz.androidassignment.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.devfaiz.androidassignment.MainActivity
import com.devfaiz.androidassignment.R
import com.devfaiz.androidassignment.ViewPagerAdapter
import com.devfaiz.androidassignment.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_quiz, container, false)
        val viewModel = ViewModelProvider(this)[QuizFragmentViewModel::class.java]
        binding.viewModel = viewModel
        val checkedId = binding.radioGroup.checkedRadioButtonId
        binding.actionButton.setOnClickListener {
            if (checkedId!=-1){
                var answerId = 0
            when(checkedId){
                R.id.option2 -> answerId =1
                R.id.option3 -> answerId =2
                R.id.option4 -> answerId =3
            }
                viewModel.next(answerId)
        }
        }
        return binding.root
    }

}