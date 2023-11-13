package com.devfaiz.androidassignment.notes

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.devfaiz.androidassignment.R
import com.devfaiz.androidassignment.databinding.FragmentNotesBinding


class NotesFragment : Fragment() {
    private lateinit var binding: FragmentNotesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_notes, container, false)
        binding.noteText.movementMethod = ScrollingMovementMethod()
        return binding.root
    }

}