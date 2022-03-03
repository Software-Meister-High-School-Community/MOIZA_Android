package com.moizaandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.ui.base.BaseViewModel

class MainViewModel : BaseViewModel() {
    private var _categoryType = MutableLiveData<String>()
    val categoryType : LiveData<String>
        get() = _categoryType

    fun setCategoryType(type : Int) {
        when (type) {
            R.id.android_btn -> _categoryType.value = "Android"
            R.id.ai_btn -> _categoryType.value = "AI"
            R.id.back_btn -> _categoryType.value = "Back-End"
            R.id.design_btn -> _categoryType.value = "Design"
            R.id.embedded_btn -> _categoryType.value = "Embedded"
            R.id.front_btn -> _categoryType.value = "Front-End"
            R.id.game_btn -> _categoryType.value = "Game"
            R.id.ios_btn -> _categoryType.value = "iOS"
            R.id.security_btn -> _categoryType.value = "Security"
        }
    }
}