package com.moizaandroid.moiza.ui.component.board.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.moizaandroid.moiza.R

class PostDialog : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_search_sort, container, false)
    }

    companion object {
        const val TAG = "SortBottomSheetFragment"
    }

}