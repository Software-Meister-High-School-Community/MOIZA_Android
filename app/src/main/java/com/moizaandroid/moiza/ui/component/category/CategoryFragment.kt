package com.moizaandroid.moiza.ui.component.category

import androidx.navigation.fragment.findNavController
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentCategoryBinding
import com.moizaandroid.moiza.ui.base.BaseFragment

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category) {
    override fun init() {
        clickSearchBtn()
    }

    fun clickSearchBtn() {
        binding.searchBtn.setOnClickListener {
            this.findNavController().navigate(R.id.action_categoryFragment_to_searchFragment)
        }
    }
}