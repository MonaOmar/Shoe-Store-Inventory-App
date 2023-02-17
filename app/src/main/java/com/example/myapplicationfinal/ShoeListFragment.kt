package com.example.myapplicationfinal

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myapplicationfinal.databinding.FragmentShoeListBinding
import com.example.myapplicationfinal.model.ShoeLayout
import com.example.myapplicationfinal.model.ShoeListingViewModel


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
   private val shoeListingViewModel:ShoeListingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.lifecycleOwner = this
        shoeListingViewModel.getShoeLiveData().observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                createShoes(it)
            }
        })
        binding.btn.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoe_listings_to_shoe_details)
        }
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
    private fun createShoes(shoes: List<Shoe>) {
        context?.let { context ->
            val shoeContainer = binding.list1
            shoes.forEach { shoe ->
                val shoeLayout = ShoeLayout(context)
                shoeLayout.loadShoe(shoe)
                shoeContainer.addView(shoeLayout)
            }
        }
    }

}