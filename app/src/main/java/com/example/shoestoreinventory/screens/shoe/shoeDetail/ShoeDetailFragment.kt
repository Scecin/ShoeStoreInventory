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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.ShoeDetailFragmentBinding
import com.example.shoestoreinventory.screens.shoe.ShoeViewModel
import com.example.shoestoreinventory.screens.shoe.shoeList.Shoe


class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding: ShoeDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail_fragment, container, false
        )

        // Add viewModel
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        // Set the viewmodel for databinding - this allows the bound layout access to all of the
        // data in the VieWModel
        //binding.shoeViewModel= viewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.setLifecycleOwner(this)

        // Add the Spinner
        val options: Spinner = binding.addGenderSpinner

        val list = resources.getStringArray(R.array.options)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, list)

        options.adapter = adapter

        // Add onclickListeners
        binding.addShoeButton.setOnClickListener {v: View ->
            Toast.makeText(activity, "The new item has been created", Toast.LENGTH_SHORT).show()
           v.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )

        // LiveData Observes
        viewModel.name.observe(viewLifecycleOwner, Observer { newName ->
            binding.addNameText.text = newName
        })
        viewModel.brand.observe(viewLifecycleOwner, Observer { newBrand ->
            binding.addBrandText.text = newBrand
        })
        viewModel.gender.observe(viewLifecycleOwner, Observer {
            binding.addGenderSpinner.selectedItem.toString()
        })
        viewModel.size.observe(viewLifecycleOwner, Observer { newSize ->
            binding.addSizeText.text = newSize
        })
        viewModel.description.observe(viewLifecycleOwner, Observer { newDescription ->
            binding.addDescriptionText.text = newDescription
        })
        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            saveShoe()
        })

        return binding.root
    }

        private fun saveShoe() {
        val newShoe = Shoe(
            name = binding.addNameText.text.toString(),
            brand = binding.addBrandText.text.toString(),
            gender = binding.addGenderSpinner.selectedItem.toString(),
            size = binding.addSizeText.text.toString(),
            description = binding.addDescriptionText.text.toString()
        )
        viewModel.addShoe(newShoe)
        //TODO viewModel.addShoe(newShoe) to list
    }


}