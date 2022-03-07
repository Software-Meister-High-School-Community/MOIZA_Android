package com.moizaandroid.moiza.ui.component.profile.setting

import androidx.navigation.fragment.findNavController
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentProfileSettingBinding
import com.moizaandroid.moiza.ui.base.BaseFragment

class SettingFragment: BaseFragment<FragmentProfileSettingBinding>(R.layout.fragment_profile_setting) {
    override fun init() {
        clickBackBtn()
    }

    private fun clickBackBtn(){
        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}