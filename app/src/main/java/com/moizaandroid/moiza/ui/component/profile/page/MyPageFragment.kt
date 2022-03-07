package com.moizaandroid.moiza.ui.component.profile.page

import android.view.View
import androidx.navigation.fragment.findNavController
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentProfileMypageBinding
import com.moizaandroid.moiza.ui.base.BaseFragment

class MyPageFragment :
    BaseFragment<FragmentProfileMypageBinding>(R.layout.fragment_profile_mypage), View.OnClickListener {
    override fun init() {
        initClick()
    }

    private fun initClick(){
        binding.apply {
            settingTabBtn.setOnClickListener(this@MyPageFragment)
            followerLayout.setOnClickListener(this@MyPageFragment)
            followingLayout.setOnClickListener(this@MyPageFragment)
            editProfileBtn.setOnClickListener(this@MyPageFragment)
            editSettingBtn.setOnClickListener(this@MyPageFragment)
        }
    }

    override fun onClick(widget: View){
        when(widget.id){
            R.id.settingTabBtn -> binding.settingLayout.visibility = View.VISIBLE
            R.id.followerLayout -> this.findNavController().navigate(R.id.action_myPageFragment_to_myFollowFragment)
            R.id.followingLayout -> this.findNavController().navigate(R.id.action_myPageFragment_to_myFollowFragment)
            R.id.editProfileBtn -> this.findNavController().navigate(R.id.action_myPageFragment_to_editFragment)
            R.id.editSettingBtn -> this.findNavController().navigate(R.id.action_myPageFragment_to_settingFragment)
        }
    }
}