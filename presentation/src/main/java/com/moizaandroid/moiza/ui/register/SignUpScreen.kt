package com.moizaandroid.moiza.ui.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.ui.component.Agreed
import com.moizaandroid.moiza.ui.component.AppBar
import com.moizaandroid.moiza.ui.component.MoizaCheckBox
import com.moizaandroid.moiza.ui.component.StepsProgressBar
import com.moizaandroid.moiza.ui.theme.*

@Composable
fun SignUpScreen(
    isBackBtnClick: () -> Unit
) {
    val currentStep by remember {
        mutableStateOf(1)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppBar(text = "회원가입", isSignUp = true) {
            isBackBtnClick()
        }

        Spacer(modifier = Modifier.height(12.dp))

        StepsProgressBar(
            numberOfSteps = 3,
            currentStep = currentStep,
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

        BottomAgreed()
    }
}

@Composable
fun BottomAgreed(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(
                Gray200
            )
            .padding(horizontal = 22.dp)
    ) {
        var agree1 by remember { mutableStateOf(true) }
        var agree2 by remember { mutableStateOf(true) }
        var agree3 by remember { mutableStateOf(true) }
        var agree4 by remember { mutableStateOf(true) }

        MoizaCheckBox(
            text = "전체 약관 동의",
            onCheckOn = { agree1 = true },
            onCheckOff = { agree2 = false },
            modifier = Modifier.padding(vertical = 22.dp),
            backgroundColor = Gray200
        )

        Divider(
            color = Gray300,
            thickness = 1.dp
        )
        
        Spacer(modifier = Modifier.height(12.dp))

        Agreed(
            backgroundColor = Gray200,
            text = "개인정보 취급방침",
            onValueChange = { agree1 = it },
            required = true,
            clickDetailBtn = {},
            modifier = Modifier.padding(vertical = 12.dp)
        )

        Agreed(
            backgroundColor = Gray200,
            text = "사용자 이용 약관",
            onValueChange = { agree2 = it },
            required = true,
            clickDetailBtn = {},
            modifier = Modifier.padding(vertical = 12.dp)
        )

        Agreed(
            backgroundColor = Gray200,
            text = "개읹정보 취급방침",
            onValueChange = { agree3 = it },
            required = true,
            clickDetailBtn = {},
            modifier = Modifier.padding(vertical = 12.dp)
        )

        Agreed(
            backgroundColor = Gray200,
            text = "사용자 이용약관",
            onValueChange = { agree4 = it },
            required = true,
            clickDetailBtn = {},
            modifier = Modifier.padding(vertical = 12.dp)
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen() {

    }
}
