package com.moizaandroid.moiza.ui.component

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
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

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MoizaCheckBox(
    modifier: Modifier = Modifier,
    text: String,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    checkBoxSize: Dp = 24.dp,
    textSize: TextUnit = 14.sp,
    textColor: Color = Color.Black,
    backgroundColor: Color = Color.White,
) {

    val interactionSources = remember { MutableInteractionSource() }

    val state = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

    Row(
        modifier = modifier
            .background(color = backgroundColor)
            .clickable(
                interactionSource = interactionSources,
                indication = null
            ) {
                if (onCheckedChange != null) {
                    onCheckedChange(!checked)
                } else null
            }
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(checkBoxSize)
                .border(
                    width = 1.dp,
                    shape = CircleShape,
                    color = Gray300
                )
                .align(CenterVertically)
        ) {

            androidx.compose.animation.AnimatedVisibility(
                visible = checked,
                enter = scaleIn(tween(50)),
                exit = scaleOut(tween(50)),
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .padding(4.8.dp)
                        .clip(CircleShape)
                        .background(Orange)
                )
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
    var value1 by remember { mutableStateOf(false) }
    MoizaCheckBox(text = "체크 박스", checked = value1, onCheckedChange = { value1 = it })
}