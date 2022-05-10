package com.moizaandroid.moiza.ui.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.ui.component.AppBar
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
    }
}

@Composable
fun BottomAgreed() {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(
                Gray200
            )
    ) {

    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PreviewSignUpScreen() {
    BottomAgreed()
}
