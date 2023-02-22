package com.ozancanguz.motivate_me_app.ui.diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.data.adapter.DiaryListAdapter
import com.ozancanguz.motivate_me_app.databinding.FragmentDiaryBinding
import com.ozancanguz.motivate_me_app.util.SwipeToDelete
import com.ozancanguz.motivate_me_app.viewmodel.DiaryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_diary.*

@AndroidEntryPoint
class DiaryFragment : Fragment() {
    private var _binding: FragmentDiaryBinding? = null

    private val binding get() = _binding!!

    private val diaryViewModel: DiaryViewModel by viewModels()

    private var listAdapter=DiaryListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         _binding = FragmentDiaryBinding.inflate(inflater, container, false)
        val view = binding.root

        navigateToAdd()

        // set up Rv
        setupRv()

        // observe live data and update ui
        observeLiveData()

        return view


    }

    private fun setupRv() {
        binding.diaryRv.layoutManager=LinearLayoutManager(requireContext())
        binding.diaryRv.adapter=listAdapter
        swipeToDelete(binding.diaryRv)
    }

    private fun observeLiveData() {

        diaryViewModel.getAllData.observe(viewLifecycleOwner, Observer {
            listAdapter.updateData(it)
        })

    }


    private fun navigateToAdd() {
        binding.addbtn.setOnClickListener {
            findNavController().navigate(R.id.action_diaryFragment_to_addDiaryFragment)
        }
    }

    //swipe to delete
    private fun swipeToDelete(recyclerView: RecyclerView) {

        val swipeToDeleteCallback=object : SwipeToDelete(){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val itemtoDelete=listAdapter.todolist[viewHolder.adapterPosition]
                diaryViewModel.deleteSingleItem(itemtoDelete)
                Toast.makeText(requireContext(),"Removed successfully", Toast.LENGTH_LONG).show()


            }
        }
        val itemTouchHelper= ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }



}