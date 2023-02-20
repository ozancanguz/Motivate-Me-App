package com.ozancanguz.motivate_me_app.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.data.adapters.ImageSliderAdapter
import com.ozancanguz.motivate_me_app.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*


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
        val adapter = ImageSliderAdapter(listOf(R.drawable.nevergiveup, R.drawable.bekind, R.drawable.keep,R.drawable.mylogo))
        viewPager.adapter = adapter


        return view
    }


}