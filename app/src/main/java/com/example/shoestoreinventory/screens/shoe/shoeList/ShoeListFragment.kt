package com.example.shoestoreinventory.screens.shoe.shoeList

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.FragmentShoeListBinding
import com.example.shoestoreinventory.screens.shoe.ShoeViewModel

class ShoeListFragment: Fragment(){

    private val shareViewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false)

        // Include the menu
        setHasOptionsMenu(true)

        binding.floatingActionButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment))

        // Use the custom class
        shareViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeListUpDated ->
            shoeListUpDated.forEach {
                addShoe(it)
            }
        })

        return binding.root
    }

    private fun addShoe(shoe: Shoe) {


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}
