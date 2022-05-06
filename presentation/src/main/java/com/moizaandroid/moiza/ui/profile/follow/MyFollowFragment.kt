package com.moizaandroid.moiza.ui.profile.follow

import androidx.navigation.fragment.findNavController
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentProfileMyfollowBinding
import com.moizaandroid.moiza.ui.base.BaseFragment

class MyFollowFragment :
    BaseFragment<FragmentProfileMyfollowBinding>(R.layout.fragment_profile_myfollow) {
    override fun init() {
        clickBackBtn()
    }

    private fun clickBackBtn(){
        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}