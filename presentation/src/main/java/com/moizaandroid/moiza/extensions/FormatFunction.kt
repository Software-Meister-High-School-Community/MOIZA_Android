package com.moizaandroid.moiza.extensions

import android.util.Patterns
import java.util.regex.Pattern

fun isPasswordFormat(password: String) =
    password.matches("^(?=.*[a-zA-Z0-9])(?=.*[a-zA-Z!@#\$%^&*])(?=.*[0-9!@#\$%^&*]).{6,15}\$".toRegex())

fun isEmailFormat(email: String) =
    Patterns.EMAIL_ADDRESS.matcher(email).matches()