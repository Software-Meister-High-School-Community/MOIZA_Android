package com.moizaandroid.moiza.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInScreen(
                onBackButtonClick = { onBackButtonClick() },
                onLoginButtonClick = { },
                onSignUpClick = { },
                onFindIdClick = { },
                onFindPasswordClick = { },
            )
        }
    }

    private fun onBackButtonClick() {
        finish()
    }
}