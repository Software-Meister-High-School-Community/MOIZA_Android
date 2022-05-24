package com.moizaandroid.moiza.ui.register

sealed class NavGroup(val title: String) {
    //Authentication associated group
    object SignUpStep: NavGroup("SignUp") {
        const val AGREED = "약관 동의"
        const val INPUT_STUDENT_INFO = "재학생 정보입력"
        const val SET_SIGN_IN: String = "로그인 설정"
    }
}