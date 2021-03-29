package com.example.shoestoreinventory.screens.shoe.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.FragmentShoeDetailBinding
import com.example.shoestoreinventory.screens.shoe.ShoeViewModel


class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        // Add viewModel
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        // Set the viewmodel for databinding - this allows the bound layout access to all of the
        // data in the VieWModel
        binding.shoeViewModel = viewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.setLifecycleOwner(this)

        // Add the Spinner
        val options: Spinner = binding.addGenderSpinner

        val list = resources.getStringArray(R.array.options)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, list)

        options.adapter = adapter

        // Add onclickListeners
        binding.addShoeButton.setOnClickListener { v: View ->
            Toast.makeText(activity, "The new item has been created", Toast.LENGTH_SHORT).show()
            v.findNavController()
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )

        return binding.root
    }
}