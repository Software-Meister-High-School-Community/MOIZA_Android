package com.moiza_design.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moiza_design.icon.MoizaIcons
import com.moiza_design.theme.*
import com.palette.moiza_design.R

@Composable
fun MoizaTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    error: String? = null,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    onClick: (() -> Unit)? = null,
    hint: String? = null,
    description: String? = null
) {
    val interactionSource = remember { MutableInteractionSource() }

    val borderColor: Color = if (error == null) Gray300 else Red

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    Column {
        Box(
            modifier = modifier
                .height(44.dp)
                .background(
                    shape = RoundedCornerShape(5.dp),
                    color = Color.Transparent
                )
                .border(
                    width = 1.dp,
                    color = borderColor
                )
                .wrapContentHeight(Alignment.CenterVertically)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    if (onClick != null) {
                        onClick()
                    }
                }
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(start = 14.dp),
                    value = value,
                    onValueChange = onValueChange,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = keyboardType,
                        imeAction = imeAction
                    ),
                    visualTransformation = if (!passwordVisible && isPassword) PasswordVisualTransformation() else VisualTransformation.None,
                    maxLines = 1,
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight.Normal,
                        color = Gray500
                    ),
                    decorationBox = { innerTextField ->
                        if (value.isEmpty() && hint != null) {
                            Body3(text = hint, color = Gray400)
                        }

                        innerTextField()
                    },
                )
                if (isPassword) {
                    Image(
                        modifier = Modifier
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null
                            ) { passwordVisible = !passwordVisible },
                        painter = if (passwordVisible) painterResource(id = MoizaIcons.PasswordVisible) else painterResource(
                            id = MoizaIcons.PasswordInvisible
                        ),
                        contentDescription = stringResource(if (passwordVisible) R.string.password_visible else R.string.password_invisible),
                        alpha = if (value.isNotEmpty()) 1f else 0f
                    )
                }
            }
        }

        if (error != null) {
            Error1(
                text = error,
                modifier = Modifier.padding(start = 3.dp, top = 6.dp)
            )
        }

        if (description != null) {
            Lore1(text = description, modifier = Modifier.padding(start = 3.dp, top = 6.dp))
        }
    }

}

@Preview
@Composable
fun PreviewMoizaTextField() {
    var value by remember { mutableStateOf(String()) }
    var value2 by remember { mutableStateOf(String()) }
    var value3 by remember { mutableStateOf(String()) }
    var value4 by remember { mutableStateOf(String()) }

    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        // default text field
        MoizaTextField(
            value = value,
            onValueChange = { value = it }
        )

        Spacer(modifier = Modifier.height(15.dp))

        // password text field
        MoizaTextField(
            value = value2,
            onValueChange = { value2 = it },
            isPassword = true
        )

        Spacer(modifier = Modifier.height(15.dp))

        // error text field
        MoizaTextField(
            value = value3,
            onValueChange = { value3 = it },
            error = "특수문자는 사용할 수 없습니다!"
        )

        Spacer(modifier = Modifier.height(15.dp))

        // description text field
        MoizaTextField(
            value = value4,
            onValueChange = { value4 = it },
            description = "비밀번호는 4자리 이상 입력해주세요.",
            hint = "비밀번호"
        )
    }
}