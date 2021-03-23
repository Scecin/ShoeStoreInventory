package com.example.shoestoreinventory.screens.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.OnboardingWelcomeFragmentBinding

class OnboardingWelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: OnboardingWelcomeFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.onboarding_welcome_fragment, container, false
        )

        // Create onClickListener
        binding.welcomeNextButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_onboardingWelcomeFragment_to_onboardingFirstFragment)
        )
        return binding.root
    }

}