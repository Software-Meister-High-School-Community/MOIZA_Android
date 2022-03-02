package com.moizaandroid.moiza.ui.component.search


import androidx.navigation.fragment.findNavController
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentSearchBinding
import com.moizaandroid.moiza.ui.base.BaseFragment


class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    override fun init() {
        clickBackBtn()
    }

    private fun clickBackBtn(){
        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}