package com.ozancanguz.motivate_me_app.ui.wheel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.databinding.FragmentDiaryBinding
import com.ozancanguz.motivate_me_app.databinding.FragmentWheelgamefragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class Wheelgamefragment : Fragment() {

    private var _binding: FragmentWheelgamefragmentBinding? = null

    private val binding get() = _binding!!


    private lateinit var wheelImageView: ImageView
    private lateinit var spinButton: Button
    private lateinit var resultTextView: TextView
    private val random = Random()

    private val sectors = arrayOf(
        "“We cannot solve problems with the kind of thinking we employed when we came up with them.” — Albert Einstein",
        "Learn as if you will live forever, live like you will die tomorrow.” — Mahatma Gandhi",
        "When you change your thoughts, remember to also change your world.”—Norman Vincent Peale",
        "Success usually comes to those who are too busy looking for it.” — Henry David Thoreau",
        "Either you run the day or the day runs you.” — Jim Rohn",
        "One man with courage makes a majority.” – Andrew Jackson",
        "Opportunities don't happen, you create them.” — Chris Grosser"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWheelgamefragmentBinding.inflate(inflater, container, false)
        val view = binding.root


        wheelImageView = binding.wheelImageview
        spinButton = binding.spinButton
        resultTextView = binding.resultTextview

        spinButton.setOnClickListener {
            spinWheel()
        }


        return view

    }

    private fun spinWheel() {
        val randomDegree = random.nextInt(360)
        val sectorAngle = 360f / sectors.size
        val selectedIndex = (randomDegree / sectorAngle).toInt()

        val rotateAnimation = RotateAnimation(
            0f,
            (randomDegree + 720).toFloat(),
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        rotateAnimation.duration = 3000
        rotateAnimation.fillAfter = true
        rotateAnimation.interpolator = DecelerateInterpolator()

        wheelImageView.startAnimation(rotateAnimation)

        rotateAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                resultTextView.text = ""
                spinButton.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animation?) {
                resultTextView.text = sectors[selectedIndex]
                spinButton.isEnabled = true
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })
    }



}