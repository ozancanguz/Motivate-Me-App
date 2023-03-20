package com.ozancanguz.motivate_me_app.ui.wheel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.databinding.FragmentDiaryBinding
import com.ozancanguz.motivate_me_app.databinding.FragmentWheelgamefragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Wheelgamefragment : Fragment() {

    private var _binding: FragmentWheelgamefragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWheelgamefragmentBinding.inflate(inflater, container, false)
        val view = binding.root





        return view

    }


}