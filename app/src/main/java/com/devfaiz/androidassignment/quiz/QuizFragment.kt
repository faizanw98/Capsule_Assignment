package com.devfaiz.androidassignment.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.devfaiz.androidassignment.R
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
        viewModel.setQuestion()
        val checkedId = binding.radioGroup.checkedRadioButtonId
        viewModel.questions.observe(viewLifecycleOwner){

        }
        binding.actionButton.setOnClickListener {
            if (checkedId!=-1){
                var answerId = 0
            when(checkedId){
                R.id.option2 -> answerId =1
                R.id.option3 -> answerId =2
                R.id.option4 -> answerId =3
            }
                viewModel.nextQuestion(answerId)
        }
        }
        return binding.root
    }

}