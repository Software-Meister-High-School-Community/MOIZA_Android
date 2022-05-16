package com.moizaandroid.moiza.ui.search


import android.util.Log
import androidx.navigation.fragment.findNavController
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentSearchBinding
import com.moizaandroid.moiza.ui.base.BaseFragment
import com.moizaandroid.moiza.ui.search.result.ResultSearchFragment


class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    override fun init() {
        clickBackBtn()
        search()
    }

    private fun clickBackBtn(){
        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun search(){
        binding.searchBtn.setOnClickListener {
            childFragmentManager.beginTransaction().replace(R.id.searchFrag, ResultSearchFragment()).commit()
        }
    }
}