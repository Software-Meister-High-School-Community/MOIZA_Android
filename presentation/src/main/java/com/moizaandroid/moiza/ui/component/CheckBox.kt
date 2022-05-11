package com.moizaandroid.moiza.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moizaandroid.moiza.ui.theme.Gray300
import com.moizaandroid.moiza.ui.theme.Orange
import com.moizaandroid.moiza.ui.theme.roboto

@Composable
fun MoizaCheckBox(
    modifier: Modifier = Modifier,
    text: String,
    onCheckOn: () -> Unit,
    onCheckOff: () -> Unit,
    checkBoxSize: Dp = 24.dp,
    textSize: TextUnit = 14.sp,
    textColor: Color = Color.Black,
    backgroundColor: Color = Color.White
) {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = modifier.background(color = backgroundColor)
    ) {
        if (isChecked) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(checkBoxSize)
                    .border(
                        width = 1.dp,
                        shape = CircleShape,
                        color = Gray300
                    )
                    .padding(4.8.dp)
                    .clip(CircleShape)
                    .background(Orange)
                    .clickable { isChecked = !isChecked }
            ) {
                onCheckOn()
            }
        } else {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(checkBoxSize)
                    .border(
                        width = 1.dp,
                        shape = CircleShape,
                        color = Gray300
                    )
                    .clickable { isChecked = !isChecked }
                    .align(CenterVertically)
            ) {
                onCheckOff()
            }
        }

        Spacer(modifier = Modifier.size(10.dp))

        Text(
            text = text,
            style = TextStyle(
                fontSize = textSize,
                fontFamily = roboto,
                fontWeight = FontWeight.Normal,
                color = textColor
            ),
            modifier = Modifier.align(CenterVertically)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCheckBox() {
    MoizaCheckBox(text = "", onCheckOn = { }, onCheckOff = { })
}