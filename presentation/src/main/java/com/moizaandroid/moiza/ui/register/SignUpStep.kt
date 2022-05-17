package com.moizaandroid.moiza.ui.register

enum class SignUpStep(val title: String, val step: Int) {
    AGREED(title = "약관 동의", step = 1),
    INPUT_STUDENT_INFO(title = "재학생 정보입력", step = 2),
    SET_SIGN_IN(title = "로그인 설정", step = 3)
}