package com.moizaandroid.moiza.ui.component.post

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentPostBinding
import com.moizaandroid.moiza.ui.base.BaseFragment
import com.moizaandroid.viewmodel.MainViewModel

class PostFragment : BaseFragment<FragmentPostBinding>(R.layout.fragment_post) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        settingDialog()
        settingCategory()
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

}