package com.example.shoestoreinventory.screens.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.FragmentSecondOnboardingBinding

class OnboardingInstructionFragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding: FragmentSecondOnboardingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_second_onboarding, container, false
        )

        // Create onClickListeners
        binding.backButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_onboardingSecondFragment_to_onboardingFirstFragment)
        )
        binding.skipButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_onboardingSecondFragment_to_shoeListFragment)
        )

        return binding.root
    }
}