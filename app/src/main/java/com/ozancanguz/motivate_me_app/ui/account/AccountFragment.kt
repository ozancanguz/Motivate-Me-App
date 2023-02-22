package com.ozancanguz.motivate_me_app.ui.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ozancanguz.motivate_me_app.R
import com.ozancanguz.motivate_me_app.databinding.FragmentAccountBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : Fragment() {
    private var _binding: FragmentAccountBinding? = null

    private val binding get() = _binding!!

   private lateinit var auth:FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val view = binding.root



        FirebaseApp.initializeApp(requireContext())
        // Initialize Firebase Auth
        auth = Firebase.auth


        // setting up account information
        setupAccount()




        // signout
        signout()

        return view

    }

    private fun signout() {
        binding.signOutBtn.setOnClickListener {
            auth.signOut()
            findNavController().navigate(R.id.action_accountFragment_to_loginActivity)
        }
    }

    private fun setupAccount() {
        val currentUser=auth.currentUser
        if (currentUser != null) {
            binding.AccountEmailTv.text="E-mail: " +currentUser.email
        }


    }


}