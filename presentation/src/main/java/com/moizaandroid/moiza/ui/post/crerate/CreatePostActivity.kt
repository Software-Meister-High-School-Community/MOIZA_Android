package com.moizaandroid.moiza.ui.post.crerate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent

class CreatePostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CreatePostScreen(onPrevious = { finish() }) {

            }
        }
    }
}