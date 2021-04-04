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
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.FragmentShoeDetailBinding
import com.example.shoestoreinventory.screens.shoe.ShoeViewModel


class ShoeDetailFragment : Fragment() {

    private val shareViewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        // Set the viewmodel for databinding - this allows the bound layout access to all of the
        // data in the VieWModel
        binding.shoesDetails = shareViewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.setLifecycleOwner(this)

        // Add the Spinner
        val options: Spinner = binding.addGenderSpinner

        val list = resources.getStringArray(R.array.options)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, list)

        options.adapter = adapter

        // Add onclickListeners
        binding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )

        shareViewModel.addNewItem.observe(viewLifecycleOwner, Observer { item ->
            if (item) {
                newShoeCreated()
                shareViewModel.addNewShoeComplete()
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                shareViewModel.updateList()
            }
        })

        return binding.root
    }
    private fun newShoeCreated () {
        Toast.makeText(activity, "The new item has been created", Toast.LENGTH_SHORT).show()

    }
}