package com.moizaandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.ui.base.BaseViewModel

class MainViewModel : BaseViewModel() {
    private var _categoryType = MutableLiveData<String>()
    val categoryType: LiveData<String>
        get() = _categoryType

    fun setCategoryType(type: Int) {
        when (type) {
            R.id.androidBtn -> _categoryType.value = "Android"
            R.id.aiBtn -> _categoryType.value = "AI"
            R.id.backBtn -> _categoryType.value = "Back-End"
            R.id.designBtn -> _categoryType.value = "Design"
            R.id.embeddedBtn -> _categoryType.value = "Embedded"
            R.id.frontBtn -> _categoryType.value = "Front-End"
            R.id.gameBtn -> _categoryType.value = "Game"
            R.id.iosBtn -> _categoryType.value = "iOS"
            R.id.securityBtn -> _categoryType.value = "Security"
        }
    }
}