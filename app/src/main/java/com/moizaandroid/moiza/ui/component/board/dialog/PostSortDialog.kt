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
        binding.recentSortBtn.isChecked = binding.recentSortBtn.id == v!!.id
        binding.likeSortBtn.isChecked = binding.likeSortBtn.id == v.id
        binding.oldSortBtn.isChecked = binding.oldSortBtn.id == v.id
        binding.viewsSortBtn.isChecked = binding.viewsSortBtn.id == v.id
    }
}