package com.moizaandroid.moiza.utils

sealed class NavDestination(val title: String) {

    object SignUpStep: NavDestination("SignUp") {
        const val AGREED = "약관 동의"
        const val INPUT_STUDENT_INFO = "재학생 정보입력"
        const val SET_SIGN_IN: String = "로그인 설정"
    }

    object SignInStep: NavDestination("SignIn") {
        const val SIGN_IN = "로그인"
        const val FIND_USER_ID_INPUT_EMAIL = "이메일 입력"
        const val FIND_USER_ID_VERIFICATION_CODE = "이메일로 인증"
        const val FIND_USER_ID_CHECK_USER_ID = "아이디 확인"
        const val FIND_PASSWORD_INPUT_ID = "아이디 입력"
        const val FIND_PASSWORD_VERTIFICATION_CODE = "인증번호 확인"
        const val FIND_PASSWORD_RESET_PASSWORD = "비밀번호 재입력"
        const val FIND_PASSWORD_FINISH_RESET = "비밀번호 재등록 완료"
    }

    object BottomNav: NavDestination("BottomNav") {
        const val HOME = "홈"
        const val BOARD = "게시글"
        const val NOTIFICATION = "알림"
        const val PROFILE = "프로필"
    }
}