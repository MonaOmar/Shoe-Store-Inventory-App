package com.example.myapplicationfinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myapplicationfinal.databinding.FragmentLoginBinding
import com.example.myapplicationfinal.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentWelcomeBinding= DataBindingUtil.inflate<FragmentWelcomeBinding>(inflater, R.layout.fragment_welcome, container, false)
        binding.welcome3.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcome_to_instructions)
        }
        return binding.root

    }
}
