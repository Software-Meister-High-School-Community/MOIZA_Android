package com.moizaandroid.moiza.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moizaandroid.moiza.ui.theme.HalfOrange
import com.moizaandroid.moiza.ui.theme.Orange
import com.moizaandroid.moiza.ui.theme.body3

@Composable
fun YellowButton(
    text: String,
    satisfy: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .background(if (satisfy) Orange else HalfOrange)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, style = body3)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewYellowButton() {
    YellowButton(text = "로그인", satisfy = true, onClick = {})
}