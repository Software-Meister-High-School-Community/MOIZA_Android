package com.moizaandroid.moiza.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moizaandroid.moiza.ui.theme.*

@Composable
fun AgreedButton(
    text: String,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = {
            // do something here
        },
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF7BB661),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0xFF666699)
        ),
        enabled = true,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

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

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewAgreedButton() {
    Column() {
        AgreedButton("인증하기")

        Spacer(modifier = Modifier.height(20.dp))

        YellowButton(text = "로그인", satisfy = true, onClick = {})
    }

}