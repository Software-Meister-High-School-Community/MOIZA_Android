package com.moizaandroid.moiza.ui.component.board.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.DialogPostSortBinding

class PostSortDialog : BottomSheetDialogFragment(), View.OnClickListener {

    private var _binding: DialogPostSortBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.dialog_post_sort, container, false)
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        binding.apply {
            recentSortBtn.setOnClickListener(this@PostSortDialog)
            likeSortBtn.setOnClickListener(this@PostSortDialog)
            oldSortBtn.setOnClickListener(this@PostSortDialog)
            viewsSortBtn.setOnClickListener(this@PostSortDialog)
            sortApplyBtn.setOnClickListener(this@PostSortDialog)
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.recentSortBtn -> {
                binding.recentSortBtn.isChecked = true
                binding.likeSortBtn.isChecked = false
                binding.oldSortBtn.isChecked = false
                binding.viewsSortBtn.isChecked = false
            }
            R.id.likeSortBtn -> {
                binding.recentSortBtn.isChecked = false
                binding.likeSortBtn.isChecked = true
                binding.oldSortBtn.isChecked = false
                binding.viewsSortBtn.isChecked = false
            }
            R.id.oldSortBtn -> {
                binding.recentSortBtn.isChecked = false
                binding.likeSortBtn.isChecked = false
                binding.oldSortBtn.isChecked = true
                binding.viewsSortBtn.isChecked = false
            }
            R.id.viewsSortBtn -> {
                binding.recentSortBtn.isChecked = false
                binding.likeSortBtn.isChecked = false
                binding.oldSortBtn.isChecked = false
                binding.viewsSortBtn.isChecked = true
            }
            R.id.sortApplyBtn -> {
                dismiss()
            }
        }
    }
}