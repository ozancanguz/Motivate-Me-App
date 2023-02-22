package com.ozancanguz.motivate_me_app.ui.diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.databinding.FragmentAddDiaryBinding


class AddDiaryFragment : Fragment() {
       private var _binding: FragmentAddDiaryBinding? = null

    private val binding get() = _binding!!






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
          _binding = FragmentAddDiaryBinding.inflate(inflater, container, false)
        val view = binding.root




        return view

    }


}