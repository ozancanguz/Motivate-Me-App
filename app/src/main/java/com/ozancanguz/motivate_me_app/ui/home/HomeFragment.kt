package com.ozancanguz.motivate_me_app.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.data.adapter.ImageSliderAdapter
import com.ozancanguz.motivate_me_app.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root


        val viewPager=binding.viewPager
        val adapter = ImageSliderAdapter(listOf(R.drawable.go1, R.drawable.go2, R.drawable.go3,R.drawable.go4))
        viewPager.adapter = adapter

        return view
    }


}