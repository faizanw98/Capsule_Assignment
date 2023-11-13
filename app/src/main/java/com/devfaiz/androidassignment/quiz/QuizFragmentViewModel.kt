package com.devfaiz.androidassignment.quiz

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import kotlin.random.Random

class QuizFragmentViewModel(): ViewModel() {
    private var index = 0
    private var score = 0
    lateinit var answers:List<String>
    lateinit var currentQuestion: Questions

    data class Questions(val text: String, val answers: List<String>)
    private val _questions= MutableLiveData<List<Questions>>()
    val questions:LiveData<List<Questions>>
        get()= _questions
    init {
        val question1 =Questions(text = "Which is the most spoken language in the world", answers = listOf("English","Hindi","Spanish","Mandarin"))
        val question2 =Questions(text = "Which is the oldest written language", answers = listOf("Hurrian","Eblaite","Sumerian","Egyptian"))
        val question3 =Questions(text = "Which family does Latin come from", answers = listOf("Afro-Asiatic","Hurro-Uratian","Uralic","Indo-European"))
        val question4 =Questions(text = "Which family does Latin come from", answers = listOf("Afro-Asiatic","Hurro-Uratian","Uralic","Indo-European"))
        _questions.value =  mutableListOf(question1,question2,question3,question4).shuffled()
    }


    fun setQuestion(){
        currentQuestion = questions.value!![index]
        answers = questions.value!![index].answers.shuffled()
    }
    fun nextQuestion(id: Int){
        if (answers[id] == currentQuestion.answers[3]){
            score++
            if (index<currentQuestion.answers.lastIndex-1){
                index++
            }
        }else{
            if (index<currentQuestion.answers.lastIndex-1){
                index++
            }
            score--
        }
    }
}