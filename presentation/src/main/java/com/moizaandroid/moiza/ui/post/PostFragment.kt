package com.moizaandroid.moiza.ui.post

import android.content.Intent
import android.view.View
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentPostBinding
import com.moizaandroid.moiza.ui.base.BaseFragment
import com.moizaandroid.moiza.ui.post.crerate.CreatePostActivity
import com.moizaandroid.moiza.viewmodel.MainViewModel

class PostFragment : BaseFragment<FragmentPostBinding>(R.layout.fragment_post),
    View.OnClickListener {

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
            postBtn.setOnClickListener(this@PostFragment)
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
        binding.allPostBtn.isChecked = binding.allPostBtn.id == v!!.id
        binding.questionPostBtn.isChecked = binding.questionPostBtn.id == v.id
        binding.normalPostBtn.isChecked = binding.normalPostBtn.id == v.id

        when(v.id) {
            R.id.postBtn -> startActivity(Intent(context, CreatePostActivity::class.java))
        }
    }

}