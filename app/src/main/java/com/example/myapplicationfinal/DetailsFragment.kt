package com.example.myapplicationfinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController

import com.example.myapplicationfinal.databinding.FragmentDetailsBinding
import com.example.myapplicationfinal.model.ShoeListingViewModel




class DetailsFragment : Fragment() {
   private val shoesViewModel:ShoeListingViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.lifecycleOwner = this
        binding.shoeListingsViewModel=shoesViewModel
        binding.shoe = Shoe()

        binding.save.setOnClickListener {
            shoesViewModel.addShoe(shoesViewModel.shoe)
            view?.findNavController()?.navigate(DetailsFragmentDirections.actionShoeDetailsToShoeListings())
        }

        binding.cancel.setOnClickListener {
            view?.findNavController()?.navigate(DetailsFragmentDirections.actionShoeDetailsToShoeListings())
        }


        return binding.root
    }

}