package com.moizaandroid.moiza.ui.component.profile

import android.view.View
import androidx.navigation.fragment.findNavController
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentProfileMypageBinding
import com.moizaandroid.moiza.ui.base.BaseFragment

class MyPageFragment :
    BaseFragment<FragmentProfileMypageBinding>(R.layout.fragment_profile_mypage) {
    override fun init() {
        clickSettingBtn()
        clickFollowerBtn()
        clickFollowingBtn()
        clickEditBtn()
    }

    private fun clickSettingBtn() {
        binding.settingTabBtn.setOnClickListener {
            binding.settingLayout.visibility = View.VISIBLE
        }
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

    private fun clickEditBtn() {
        binding.editProfileBtn.setOnClickListener {
            this.findNavController().navigate(R.id.action_myPageFragment_to_editFragment)
        }
    }
}