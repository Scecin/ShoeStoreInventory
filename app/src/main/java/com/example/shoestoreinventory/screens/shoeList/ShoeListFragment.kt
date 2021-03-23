package com.example.shoestoreinventory.screens.shoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.ShoeListFragmentBinding

class ShoeListFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        val binding: ShoeListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list_fragment, container, false
        )

        val shoe = Shoe( R.drawable.boots_shoe, "Black boots", "Dr. Martens",
            "Women")
        val shoe2 = Shoe( R.drawable.heeled_shoe, "Classic white shoes", "Mustang",
            "Women")
        val shoe3 = Shoe( R.drawable.heeled_shoe1, "Classic black shoes", "Mustang",
            "Women")
        val shoe4 = Shoe( R.drawable.kid__shoe, "Multicolor kid trainers", "Adidas",
            "Women")
        val shoe5 = Shoe( R.drawable.man_shoe, "Classic men shoes", "Clarks",
            "Men")
        val shoe6 = Shoe( R.drawable.mountain_boot_shoe, "Hiking shoes", "Columbia",
            "Men")
        val shoe7 = Shoe( R.drawable.trainer_shoe, "Running trainers", "Nike",
            "Men")

        val shoeList = mutableListOf<Shoe>(shoe, shoe2, shoe3, shoe4, shoe5, shoe6, shoe7)

        val adapter = ShoeAdapter( requireContext(), shoeList)

        binding.listView.adapter = adapter

        binding.floatingActionButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment)
        )

        return binding.root
    }

}