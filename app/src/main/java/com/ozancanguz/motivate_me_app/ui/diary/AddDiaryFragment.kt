package com.ozancanguz.motivate_me_app.ui.diary

import android.icu.text.CaseMap.Title
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
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class AddDiaryFragment : Fragment() {
       private var _binding: FragmentAddDiaryBinding? = null

    private val binding get() = _binding!!

    private val diaryViewModel:DiaryViewModel by viewModels()

    private lateinit var title:String




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
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH) + 1 // Note: Month starts from 0
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val dateString = dateFormat.format(calendar.time)
            val time= "$dayOfMonth-$month-$year"
            val description=binding.descriptionEt.text.toString()
            var newData= Diary(0,time,description)
            diaryViewModel.insertData(newData)
            findNavController().navigate(R.id.action_addDiaryFragment_to_diaryFragment)
        }

    }


}