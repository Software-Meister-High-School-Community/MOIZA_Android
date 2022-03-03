package com.moizaandroid.moiza.ui.component.category

import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentCategoryBinding
import com.moizaandroid.moiza.ui.base.BaseFragment
import com.moizaandroid.viewmodel.MainViewModel

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category), View.OnClickListener {

    private val mainViewModel by activityViewModels<MainViewModel>()
    private val TAG = "CategoryFragment - TAG"

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


//    fun categoryBtn(view: View) {
//        when (view.id) {
//            R.id.front_btn -> mainViewModel.setCategoryType("Front-End")
//            R.id.back_btn -> mainViewModel.setCategoryType("Back-End")
//            R.id.ai_btn -> mainViewModel.setCategoryType("AI")
//            R.id.android_btn -> mainViewModel.setCategoryType("Android")
//            R.id.design_btn -> mainViewModel.setCategoryType("Design")
//            R.id.embedded_btn -> mainViewModel.setCategoryType("Embedded")
//            R.id.game_btn -> mainViewModel.setCategoryType("Game")
//            R.id.ios_btn -> mainViewModel.setCategoryType("iOS")
//            R.id.security_btn -> mainViewModel.setCategoryType("Security")
//        }
//    }

    override fun onClick(v: View?) {
        Log.d(TAG, "click category")
        mainViewModel.setCategoryType(v!!.id)
        this.findNavController().navigate(R.id.action_categoryFragment_to_postFragment)
    }
}