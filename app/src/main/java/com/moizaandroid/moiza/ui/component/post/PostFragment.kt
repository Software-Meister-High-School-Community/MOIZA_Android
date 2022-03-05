package com.moizaandroid.moiza.ui.component.post

import android.view.View
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentPostBinding
import com.moizaandroid.moiza.ui.base.BaseFragment
import com.moizaandroid.viewmodel.MainViewModel

class PostFragment : BaseFragment<FragmentPostBinding>(R.layout.fragment_post), View.OnClickListener {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        settingDialog()
        settingCategory()
    }

    override fun onStart() {
        super.onStart()
        binding.apply {
            allPostBtn.setOnClickListener(this@PostFragment)
            questionPostBtn.setOnClickListener(this@PostFragment)
            normalPostBtn.setOnClickListener(this@PostFragment)
        }
    }


    private fun settingCategory() {
        binding.categoryTv.text = mainViewModel.categoryType.value
    }

    private fun settingDialog() {
        val bottomSheetView = layoutInflater.inflate(R.layout.dialog_post_sort, null)
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(bottomSheetView)

        binding.sortBtn.setOnClickListener {
            bottomSheetDialog.show()
        }
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.allPostBtn -> {
                binding.apply{
                    allPostBtn.isChecked = true
                    questionPostBtn.isChecked = false
                    normalPostBtn.isChecked = false
                }
            }
            R.id.questionPostBtn -> {
                binding.apply {
                    allPostBtn.isChecked = false
                    questionPostBtn.isChecked = true
                    normalPostBtn.isChecked = false
                }
            }
            R.id.normalPostBtn -> {
                binding.apply {
                    allPostBtn.isChecked = false
                    questionPostBtn.isChecked = false
                    normalPostBtn.isChecked = true
                }
            }
        }
    }

}