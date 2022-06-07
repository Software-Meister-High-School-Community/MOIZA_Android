package com.moizaandroid.moiza.ui.post.crerate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.moizaandroid.moiza.ui.post.request.ReplayPostScreen

class CreatePostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReplayPostScreen(onPrevious = { finish() }) {

            }
        }
    }
}