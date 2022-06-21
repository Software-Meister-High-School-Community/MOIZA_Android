package com.moiza_design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moiza_design.theme.*

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
fun RoundButton(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
    enabledColor: Color = Orange,
    disabledColor: Color = HalfOrange,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .background(if (enabled) enabledColor else disabledColor)
            .clickable(
                onClick = {
                    if (enabled) onClick()
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Body3(text = text, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun GrayButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    corner_radius: Dp = 0.dp
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(corner_radius),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Gray200,
            contentColor = Gray600,
            disabledContentColor = Gray300,
            disabledBackgroundColor = Color(0xFFF8F8F8)
        )
    ) {
        Body3(text = text)
    }
}

@Composable
fun NextStepButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    buttonColor: ButtonColors = ButtonDefaults.buttonColors(
        contentColor = Color.White,
        backgroundColor = Blue,
        disabledBackgroundColor = HalfBlue,
        disabledContentColor = Gray300
    ),
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(36.dp)
            .padding(start = 16.dp, end = 16.dp),
        shape = RoundedCornerShape(25.dp),
        colors = buttonColor,
        enabled = enabled
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = roboto,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White
            )
        )
    }
}

@Composable
fun TextFieldButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(44.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(
                    5.dp
                ),
                color = Gray300
            )
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.CenterStart
    ) {
        Body3(text = text, color = Gray500, modifier = Modifier.padding(start = 14.dp))
    }
}

@Composable
fun NumberButton(
    text: String,
    number: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSources = remember { MutableInteractionSource() }

    Row(
        modifier = modifier
            .height(36.dp)
            .clickable(
                interactionSource = interactionSources,
                indication = null
            ) {
                onClick()
            }
            .background(
                shape = RoundedCornerShape(25.dp),
                color = Color.White
            )
            .border(width = 1.dp, color = Gray300, shape = RoundedCornerShape(25.dp))
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Body3(text = text, color = Gray500)

        Spacer(modifier = Modifier.width(10.dp))

        Divider(
            color = Gray400,
            modifier = Modifier
                .width(1.dp)
                .height(13.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Body3(text = number.toString(), color = Blue)
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewAgreedButton() {
    Column {
        AgreedButton("인증하기")

        Spacer(modifier = Modifier.height(20.dp))

        RoundButton(text = "로그인", enabled = true, onClick = {})

        Spacer(modifier = Modifier.height(20.dp))

        GrayButton(
            onClick = {},
            text = "아이디 중복확인"
        )

        Spacer(modifier = Modifier.height(20.dp))

        NextStepButton(
            onClick = {},
            text = "다음 단계"
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextFieldButton(modifier = Modifier.fillMaxWidth(), text = "2005", onClick = {})

        Spacer(modifier = Modifier.height(20.dp))

        NumberButton(text = "임시저장된 글", number = 10, onClick = {  })
    }

}