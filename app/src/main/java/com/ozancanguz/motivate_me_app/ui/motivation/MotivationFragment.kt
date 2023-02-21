package com.ozancanguz.motivate_me_app.ui.motivation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.api.Distribution.BucketOptions.Linear
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.data.adapter.QuoteAdapter
import com.ozancanguz.motivate_me_app.databinding.FragmentMotivationBinding
import com.ozancanguz.motivate_me_app.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_motivation.*
import java.lang.Math.abs

@AndroidEntryPoint
class MotivationFragment : Fragment() {
    private var _binding: FragmentMotivationBinding? = null

    private val binding get() = _binding!!

    private lateinit var gestureDetector: GestureDetector


    // init viewmodel
    private val quoteViewModel:QuoteViewModel by viewModels()

    // init adapter
    private val quoteAdapter=QuoteAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        gestureDetector = GestureDetector(requireContext(), object : GestureDetector.SimpleOnGestureListener() {
            override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
                val distanceX = e2.x - e1.x
                val distanceY = e2.y - e1.y

                if (abs(distanceX) > abs(distanceY) && abs(distanceX) > 100 && abs(velocityX) > 100) {
                    if (distanceX < 0) {
                        // Left swipe detected
                        quoteViewModel.getQuote()
                    }
                }
                return super.onFling(e1, e2, velocityX, velocityY)
            }
        })

        // Attach gesture detector to RecyclerView
        recyclerView.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
            false
        }
    }


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
        binding.pbmotivation.visibility=View.VISIBLE
          quoteViewModel.getQuote()
        quoteViewModel.quote.observe(viewLifecycleOwner, Observer {
            quoteAdapter.setData(it)
            binding.pbmotivation.visibility=View.INVISIBLE
        })
    }

    private fun setupRv() {
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=quoteAdapter
    }






}