package com.example.shoestoreinventory.screens.shoe.shoeList

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.ShoeListFragmentBinding
import com.example.shoestoreinventory.screens.shoe.ShoeViewModel

class ShoeListFragment: Fragment(){

    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        val binding: ShoeListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list_fragment, container, false
        )

        // Add viewModel
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        // Add new view
//        val linearLayout: LinearLayout = binding.shoesLinearLayout
//        binding.shoesLinearLayout.addView(newShoe)


        // Include the menu
        setHasOptionsMenu(true)

        binding.floatingActionButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment)
        )

        // Use the custom layout
        viewModel.shoeList.forEach { shoe ->
            val shoeView = ShoeView(requireContext())
            shoeView.setShoeItemView(shoe)
            binding.shoesLinearLayout.addView(shoeView)
        }

        return binding.root
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