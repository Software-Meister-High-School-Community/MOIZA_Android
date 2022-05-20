package com.moizaandroid.moiza.ui.register

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.ui.component.AppBar
import com.moizaandroid.moiza.ui.component.MoizaCheckBox
import com.moizaandroid.moiza.ui.component.MoizaVerticalMenus
import com.moizaandroid.moiza.ui.component.StepsProgressBar
import com.moizaandroid.moiza.ui.theme.*

@Composable
fun SignUpInputStudentScreen(
    isBackBtnClick: () -> Unit
) {
    val currentStep: SignUpStep by remember {
        mutableStateOf(SignUpStep.INPUT_STUDENT_INFO)
    }

    val verticalScroll = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .verticalScroll(verticalScroll)
    ) {
        AppBar(text = stringResource(id = R.string.sign_up), isSignUp = true) {
            isBackBtnClick()
        }

        Spacer(modifier = Modifier.height(12.dp))

        StepsProgressBar(
            numberOfSteps = 3,
            currentStep = currentStep.step,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(25.dp))

        SubTitle1(
            text = stringResource(id = R.string.input_info),
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(43.dp))

        Body3(text = "구분")

        Spacer(modifier = Modifier.height(15.dp))

        var graduate by remember { mutableStateOf(false) }
        var ungraduate by remember { mutableStateOf(false) }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            MoizaCheckBox(
                modifier = Modifier.fillMaxWidth(0.5f),
                text = "재학생",
                checked = ungraduate,
                onCheckedChange = {
                    ungraduate = it
                    graduate = !it
                }
            )
            MoizaCheckBox(
                text = "졸업생",
                checked = graduate,
                onCheckedChange = {
                    graduate = it
                    ungraduate = !it
                }
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Body3(text = "이름")

        Spacer(modifier = Modifier.height(15.dp))

        var name by remember { mutableStateOf(String()) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                singleLine = true,
                isError = false,
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    color = Gray500,
                    fontWeight = FontWeight.Normal,
                    fontFamily = roboto
                ),
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(10.dp))

            var isMale by remember { mutableStateOf(true) }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(44.dp)
                    .border(
                        shape = RoundedCornerShape(topStart = 1.dp, bottomStart = 1.dp),
                        width = 1.dp,
                        color = Gray300
                    )
                    .background(color = if (isMale) Orange else Color.White)
                    .clickable {
                        isMale = !isMale
                    }
            ) {
                Body3(
                    text = stringResource(id = R.string.male), modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Center)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(44.dp)
                    .border(
                        shape = RoundedCornerShape(topEnd = 1.dp, bottomEnd = 1.dp),
                        width = 1.dp,
                        color = Gray300
                    )

                    .background(if (!isMale) Orange else Color.White)
                    .clickable {
                        isMale = !isMale
                    }
            ) {
                Body3(
                    text = stringResource(id = R.string.female), modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Center)
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Body3(text = "생년월일 8자리")

        Spacer(modifier = Modifier.height(15.dp))

        var birthDay by remember { mutableStateOf(String()) }

        OutlinedTextField(
            value = birthDay,
            onValueChange = { birthDay = it },
            singleLine = true,
            isError = false,
            textStyle = TextStyle(
                fontSize = 14.sp,
                color = Gray500,
                fontWeight = FontWeight.Normal,
                fontFamily = roboto
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Body3(text = "학교 선택")
        
        Spacer(modifier = Modifier.height(15.dp ))

        val menus = listOf(
            stringResource(id = R.string.dsm),
            stringResource(id = R.string.dgsm),
            stringResource(id = R.string.bsm),
            stringResource(id = R.string.gsm),
            stringResource(id = R.string.mirim)
        )

        var menu = "no data"
        MoizaVerticalMenus(onMenuClicked = { menu = it }, menus = menus)

    }
}

@Preview(
    showBackground = true,
    heightDp = 1500
)
@Composable
fun PreviewSignUpInputStudentScreen() {
    SignUpInputStudentScreen() {}
}