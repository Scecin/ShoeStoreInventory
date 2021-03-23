package com.example.shoestoreinventory.screens.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.ShoeDetailFragmentBinding


class ShoeDetailFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding: ShoeDetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail_fragment, container, false
        )

        // Add the Spinner
        val options: Spinner = binding.addGenderSpinner

        val list = resources.getStringArray(R.array.options)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, list)

        options.adapter = adapter

        // Add onclickListeners
        binding.addShoeButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )
        binding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )
        return binding.root
    }
}