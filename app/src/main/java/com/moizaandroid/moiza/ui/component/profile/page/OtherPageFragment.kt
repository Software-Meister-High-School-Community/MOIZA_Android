package com.moizaandroid.moiza.ui.component.profile.page

import android.view.View
import androidx.navigation.fragment.findNavController
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentProfileOtherpageBinding
import com.moizaandroid.moiza.ui.base.BaseFragment

class OtherPageFragment :
    BaseFragment<FragmentProfileOtherpageBinding>(R.layout.fragment_profile_otherpage) {
    override fun init() {
        clickFollowerBtn()
        clickFollowingBtn()
    }

    private fun clickFollowerBtn() {
        binding.followerLayout.setOnClickListener {
            this.findNavController().navigate(R.id.action_myPageFragment_to_myFollowFragment)
        }
    }

    private fun clickFollowingBtn() {
        binding.followingLayout.setOnClickListener {
            this.findNavController().navigate(R.id.action_myPageFragment_to_myFollowFragment)
        }
    }
}