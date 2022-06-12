package com.moizaandroid.moiza.ui.post.request

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.moiza_design.theme.MoizaTheme

class ReplyPostActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContent {
            MoizaTheme() {
                ReplayPostScreen(onPrevious = { finish() }) {
                    //TODO("작성")
                }
            }

        }
    }
}