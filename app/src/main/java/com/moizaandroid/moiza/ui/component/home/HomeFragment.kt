package com.moizaandroid.moiza.ui.component.home


import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentHomeBinding
import com.moizaandroid.moiza.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun init() {
        initSchoolBanner()
    }

    private fun initSchoolBanner(){
        binding.schoolBanner.adapter = HomeBannerAdapter()
    }
}