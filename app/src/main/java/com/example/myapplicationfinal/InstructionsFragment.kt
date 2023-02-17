package com.example.myapplicationfinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myapplicationfinal.databinding.FragmentInstructionsBinding
import com.example.myapplicationfinal.databinding.FragmentWelcomeBinding


class InstructionsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstructionsBinding = DataBindingUtil.inflate<FragmentInstructionsBinding>(inflater, R.layout.fragment_instructions, container, false)
        binding.inst3.setOnClickListener {
            it.findNavController().navigate(R.id.action_instructions_to_shoe_listings)
        }
        return binding.root

    }

    }
