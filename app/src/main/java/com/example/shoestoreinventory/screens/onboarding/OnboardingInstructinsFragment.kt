package com.example.shoestoreinventory.screens.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.OnboardingFirstFragmentBinding

class OnboardingInstructinsFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding: OnboardingFirstFragmentBinding= DataBindingUtil.inflate(
            inflater, R.layout.onboarding_first_fragment, container, false)

        // Create onclickListeners
        binding.backButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_onboardingFirstFragment_to_onboardingWelcomeFragment)
        )

        binding.nextButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_onboardingFirstFragment_to_onboardingSecondFragment)
        )

        return binding.root
    }
}