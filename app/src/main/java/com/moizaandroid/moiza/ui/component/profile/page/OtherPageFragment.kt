package com.moizaandroid.moiza.ui.component.profile.page

import android.view.View
import androidx.navigation.fragment.findNavController
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentProfileOtherpageBinding
import com.moizaandroid.moiza.ui.base.BaseFragment

class OtherPageFragment :
    BaseFragment<FragmentProfileOtherpageBinding>(R.layout.fragment_profile_otherpage), View.OnClickListener {
    override fun init() {
        initClick()
    }

    private fun initClick(){
        binding.apply {
            followerLayout.setOnClickListener(this@OtherPageFragment)
            followingLayout.setOnClickListener(this@OtherPageFragment)
        }
    }

    override fun onClick(widget: View){
        when(widget.id){
            R.id.followerLayout -> this.findNavController().navigate(R.id.action_myPageFragment_to_myFollowFragment)
            R.id.followingLayout -> this.findNavController().navigate(R.id.action_myPageFragment_to_myFollowFragment)
        }
    }
}