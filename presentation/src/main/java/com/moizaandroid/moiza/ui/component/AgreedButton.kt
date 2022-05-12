package com.moizaandroid.moiza.ui.component

import androidx.compose.foundation.background
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.moizaandroid.moiza.ui.theme.Black

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

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewAgreedButton() {
    AgreedButton("123")
}