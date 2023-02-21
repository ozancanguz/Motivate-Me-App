package com.ozancanguz.motivate_me_app.ui.motivation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.api.Distribution.BucketOptions.Linear
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.data.adapter.QuoteAdapter
import com.ozancanguz.motivate_me_app.databinding.FragmentMotivationBinding
import com.ozancanguz.motivate_me_app.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MotivationFragment : Fragment() {
    private var _binding: FragmentMotivationBinding? = null

    private val binding get() = _binding!!

    // init viewmodel
    private val quoteViewModel:QuoteViewModel by viewModels()

    // init adapter
    private val quoteAdapter=QuoteAdapter()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
          _binding = FragmentMotivationBinding.inflate(inflater, container, false)
        val view = binding.root

        // setting up recyclerview
        setupRv()


        // observe live data and update ui
        observeLiveData()

        return view

    }

    private fun observeLiveData(){
        quoteViewModel.getQuote()
        quoteViewModel.quote.observe(viewLifecycleOwner, Observer {
            quoteAdapter.setData(it)
        })
    }

    private fun setupRv() {
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=quoteAdapter
    }


}