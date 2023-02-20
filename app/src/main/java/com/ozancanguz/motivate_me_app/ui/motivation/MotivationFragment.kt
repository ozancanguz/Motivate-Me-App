package com.ozancanguz.motivate_me_app.ui.motivation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.databinding.FragmentMotivationBinding


class MotivationFragment : Fragment() {
    private var _binding: FragmentMotivationBinding? = null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
          _binding = FragmentMotivationBinding.inflate(inflater, container, false)
        val view = binding.root

        return view

    }


}