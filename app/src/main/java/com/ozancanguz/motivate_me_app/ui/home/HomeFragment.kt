package com.ozancanguz.motivate_me_app.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.data.adapter.ImageSliderAdapter

import com.ozancanguz.motivate_me_app.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.bottom_sheet_layout.*


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


        // setting up slider
        val viewPager=binding.viewPager
        val adapter = ImageSliderAdapter(listOf(R.drawable.go1, R.drawable.go2, R.drawable.go3,R.drawable.go4))
        viewPager.adapter = adapter


        // navigation to other screen
        nav()


        emojiPicker()

        return view
    }



    private fun nav() {
        binding.diarynav.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_diaryFragment)
        }
        binding.motivationalnav.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_motivationFragment)
        }
    }

    private fun emojiPicker() {

        binding.feelingText.setOnClickListener {
            val bottomSheet = BottomSheetDialog(requireContext())
            bottomSheet.setContentView(R.layout.bottom_sheet_layout)


            val emoji1 = bottomSheet.emoji1
            val emoji2 = bottomSheet.emoji2
            val emoji3 = bottomSheet.emoji3
            val emoji4 = bottomSheet.emoji4
            val emoji5 = bottomSheet.emoji5
            val emoji6 = bottomSheet.emoji6
            val emoji7 = bottomSheet.emoji7
            val emoji8 = bottomSheet.emoji8

            emoji1?.setOnClickListener {
               binding.emojiText.setText("😀")
                bottomSheet.dismiss()
            }

            emoji2?.setOnClickListener {
                binding.emojiText.setText("😂")
                bottomSheet.dismiss()
            }

            emoji3?.setOnClickListener {
                binding.emojiText.setText("😍")
                bottomSheet.dismiss()
            }

            emoji4?.setOnClickListener {
                binding.emojiText.setText("🤔")
                bottomSheet.dismiss()
            }

            emoji5?.setOnClickListener {
                binding.emojiText.setText("😴")
                bottomSheet.dismiss()
            }

            emoji6?.setOnClickListener {
                binding.emojiText.setText("🤢")
                bottomSheet.dismiss()
            }

            emoji7?.setOnClickListener {
                binding.emojiText.setText("😭")
                bottomSheet.dismiss()
            }

            emoji8?.setOnClickListener {
                binding.emojiText.setText("🥳")
                bottomSheet.dismiss()
            }

            bottomSheet.show()
        }
    }


    }



