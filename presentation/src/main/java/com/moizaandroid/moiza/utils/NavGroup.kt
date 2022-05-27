package com.moizaandroid.moiza.utils

sealed class NavGroup(val title: String) {

    object SignUpStep: NavGroup("SignUp") {
        const val AGREED = "약관 동의"
        const val INPUT_STUDENT_INFO = "재학생 정보입력"
        const val SET_SIGN_IN: String = "로그인 설정"
    }

    object SignInStep: NavGroup("SignIn") {
        const val SIGN_IN = "로그인"
        const val FIND_USER_ID_INPUT_EMAIL = "이메일 입력"
        const val FIND_USER_ID_VERIFICATION_CODE = "이메일로 인증"
        const val FIND_USER_ID_CHECK_USER_ID = "아이디 확인"
    }
}