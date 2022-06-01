package com.moizaandroid.moiza.ui.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moiza_design.theme.*
import com.moizaandroid.moiza.R
import com.moiza_design.component.Agreed
import com.moiza_design.component.AppBar
import com.moiza_design.component.MoizaCheckBox
import com.moiza_design.component.StepsProgressBar

@Composable
fun SignUpAgreedScreen(
    toPrevious: () -> Unit,
    toNextStep: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppBar(text = stringResource(id = R.string.sign_up), isSignUp = true) {
            toPrevious()
        }

        Spacer(modifier = Modifier.height(12.dp))

        StepsProgressBar(
            numberOfSteps = 3,
            currentStep = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        SubTitle1(
            text = stringResource(id = R.string.agreed),
            color = Color.Black,
            modifier = Modifier.padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Body3(
            text = "원활한 모이자 활동과 서비스 제공을 위해\n꼭 필요한 정보입니다.",
            color = Gray500,
            modifier = Modifier.padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        BottomAgreed(toNextStep = toNextStep)
    }
}

@Composable
fun BottomAgreed(modifier: Modifier = Modifier, toNextStep: () -> Unit) {
    Column(
        modifier = modifier
            .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(
                Gray200
            )
            .padding(horizontal = 22.dp)
            .fillMaxHeight(fraction = 0.8f)
    ) {
        var agree1 by remember { mutableStateOf(false) }
        var agree2 by remember { mutableStateOf(false) }
        var agree3 by remember { mutableStateOf(false) }
        var agree4 by remember { mutableStateOf(false) }

        MoizaCheckBox(
            text = stringResource(id = R.string.agreed_all),
            checked = (agree1 && agree2 && agree3 && agree4),
            modifier = Modifier.padding(vertical = 22.dp),
            backgroundColor = Gray200,
            onCheckedChange = {
                if (it) {
                    agree1 = true; agree2 = true; agree3 = true; agree4 = true
                } else {
                    agree1 = false; agree2 = false; agree3 = false; agree4 = false
                }
            }
        )

        Divider(
            color = Gray300,
            thickness = 0.5.dp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Agreed(
            backgroundColor = Gray200,
            text = "개인정보 취급방침",
            checked = agree1,
            onCheckedChange = { agree1 = it },
            required = true,
            clickDetailBtn = {},
            modifier = Modifier.padding(vertical = 12.dp),
        )

        Agreed(
            backgroundColor = Gray200,
            text = "사용자 이용 약관",
            checked = agree2,
            onCheckedChange = { agree2 = it },
            required = true,
            clickDetailBtn = {},
            modifier = Modifier.padding(vertical = 12.dp),
        )

        Agreed(
            backgroundColor = Gray200,
            text = "개읹정보 취급방침",
            checked = agree3,
            onCheckedChange = { agree3 = it },
            required = true,
            clickDetailBtn = {},
            modifier = Modifier.padding(vertical = 12.dp),
        )

        Agreed(
            backgroundColor = Gray200,
            text = "사용자 이용약관",
            checked = agree4,
            onCheckedChange = { agree4 = it },
            required = true,
            clickDetailBtn = {},
            modifier = Modifier.padding(vertical = 12.dp),
        )

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(
            onClick = { toNextStep() },
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.White,
                contentColor = Color.Black,
                disabledContentColor = Gray300
            ),
            enabled = (agree1 && agree2 && agree3 && agree4),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            Text(
                text = "동의하고 계속",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = roboto,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PreviewSignUpScreen() {
    SignUpAgreedScreen({}) {

    }
}
