package com.ozancanguz.motivate_me_app.ui.diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.data.models.diary.Diary
import com.ozancanguz.motivate_me_app.databinding.FragmentAddDiaryBinding
import com.ozancanguz.motivate_me_app.viewmodel.DiaryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddDiaryFragment : Fragment() {
       private var _binding: FragmentAddDiaryBinding? = null

    private val binding get() = _binding!!

    private val diaryViewModel:DiaryViewModel by viewModels()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
          _binding = FragmentAddDiaryBinding.inflate(inflater, container, false)
        val view = binding.root



        insertToDb()


        return view

    }


    fun insertToDb(){
        binding.addtoDb.setOnClickListener {
            val title=binding.titleEt.text.toString()
            val description=binding.descriptionEt.text.toString()
            var newData= Diary(0,title,description)
            diaryViewModel.insertData(newData)
            findNavController().navigate(R.id.action_addDiaryFragment_to_diaryFragment)
        }

    }


}