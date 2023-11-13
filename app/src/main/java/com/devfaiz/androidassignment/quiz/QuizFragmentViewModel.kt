package com.devfaiz.androidassignment.quiz

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import kotlin.random.Random

class QuizFragmentViewModel(): ViewModel() {
     var index = 0
    var score = 0
    private var _navigate= MutableLiveData<Boolean>()
    val navigate: LiveData<Boolean>
        get()= _navigate
    lateinit var answers: LiveData<List<String>>
    data class Questions(val text: String, val answers: List<String>)
    private val _questions= MutableLiveData<List<Questions>>()
    val questions:LiveData<List<Questions>>
        get()= _questions
    init {
        val question1 =Questions(text = "Which is the most spoken language in the world", answers = listOf("English","Hindi","Spanish","Mandarin"))
        _questions.value =  mutableListOf(question1)
        _navigate.value = false
    }
    fun next(id: Int){
        if (id== questions.value?.get(0)?.answers?.lastIndex){
            score++
        }
    }

}