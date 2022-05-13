package com.moizaandroid.moiza.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.moizaandroid.moiza.ui.theme.Body3
import com.moizaandroid.moiza.ui.theme.Gray200
import com.moizaandroid.moiza.ui.theme.Gray400

@Composable
fun Agreed(
    text: String,
    required: Boolean = false,
    backgroundColor: Color = Color.White,
    onValueChange: ((Boolean) -> Unit)?,
    clickDetailBtn: () -> Unit = {},
    modifier: Modifier = Modifier,
    checkState: Boolean = false
) {

    Box(
        modifier = modifier
            .background(color = backgroundColor)
            .fillMaxWidth()
    ) {
        if (onValueChange != null) {
            MoizaCheckBox(
                text = if (required) "$text (필수)" else text,
                onCheckOn = { onValueChange(true) },
                onCheckOff = { onValueChange(false) },
                modifier = Modifier.align(
                    Alignment.CenterStart
                ),
                textSize = 14.sp,
                checkBoxSize = 20.dp,
                backgroundColor = backgroundColor,
                checkState = checkState
            )

            Body3(
                text = "보기",
                color = Gray400,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clickable { clickDetailBtn() })
        }
    }

}

@Preview
@Composable
fun PreviewAgreed() {
    Agreed(
        backgroundColor = Gray200,
        text = "개인정보 취급방침",
        onValueChange = {  },
        required = true,
        clickDetailBtn = {},
        modifier = Modifier.padding(vertical = 12.dp)
    )
}