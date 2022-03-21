package com.moizaandroid.moiza.ui.login

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.moizaandroid.moiza.ui.theme.MoizaTheme

@Composable
fun SignInScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "로그인")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                backgroundColor = Color.White,
                contentColor = Color.Black
            )
        },
        content = {
            // Body content
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoizaTheme {
        SignInScreen()
    }
}