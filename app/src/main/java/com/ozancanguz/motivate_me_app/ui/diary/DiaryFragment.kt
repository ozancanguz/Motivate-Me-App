package com.ozancanguz.motivate_me_app.ui.diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.databinding.FragmentDiaryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiaryFragment : Fragment() {
    private var _binding: FragmentDiaryBinding? = null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         _binding = FragmentDiaryBinding.inflate(inflater, container, false)
        val view = binding.root

        navigateToAdd()


        return view


    }

    private fun navigateToAdd() {
        binding.addbtn.setOnClickListener {
            findNavController().navigate(R.id.action_diaryFragment_to_addDiaryFragment)
        }
    }


}