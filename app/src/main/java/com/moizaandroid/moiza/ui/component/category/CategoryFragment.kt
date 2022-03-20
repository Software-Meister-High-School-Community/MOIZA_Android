package com.moizaandroid.moiza.ui.component.category

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentCategoryBinding
import com.moizaandroid.moiza.ui.base.BaseFragment
import com.moizaandroid.moiza.viewmodel.MainViewModel

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category),
    View.OnClickListener {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        clickSearchBtn()
    }

    private fun clickSearchBtn() {
        binding.searchTabBtn.setOnClickListener {
            this.findNavController().navigate(R.id.action_categoryFragment_to_searchFragment)
        }
    }

    override fun onStart() {
        super.onStart()
        binding.apply {
            androidBtn.setOnClickListener(this@CategoryFragment)
            aiBtn.setOnClickListener(this@CategoryFragment)
            backBtn.setOnClickListener(this@CategoryFragment)
            designBtn.setOnClickListener(this@CategoryFragment)
            embeddedBtn.setOnClickListener(this@CategoryFragment)
            frontBtn.setOnClickListener(this@CategoryFragment)
            gameBtn.setOnClickListener(this@CategoryFragment)
            iosBtn.setOnClickListener(this@CategoryFragment)
            securityBtn.setOnClickListener(this@CategoryFragment)
        }
    }

    override fun onClick(v: View?) {
        mainViewModel.setCategoryType(v!!.id)
        this.findNavController().navigate(R.id.action_categoryFragment_to_postFragment)
    }
}