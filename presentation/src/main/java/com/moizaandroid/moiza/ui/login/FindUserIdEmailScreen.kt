package com.moizaandroid.moiza.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moiza_design.theme.*
import com.moizaandroid.moiza.R
import com.moiza_design.component.AppBar
import com.moiza_design.component.GrayButton
import com.moiza_design.component.MoizaTextField
import com.moiza_design.component.NextStepButton

@Composable
fun FindUserIdEmailScreen(
    toPrevious: () -> Unit,
    toNextStep: () -> Unit
) {
    var userEmail by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppBar(text = stringResource(id = R.string.find_id)) {
            toPrevious()
        }

        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(36.dp))

            SubTitle3(text = stringResource(id = R.string.verification_email))

            Spacer(modifier = Modifier.height(30.dp))

            MoizaTextField(value = userEmail ?: "", onValueChange = { userEmail = it })

            Spacer(modifier = Modifier.height(127.dp))

            NextStepButton(
                onClick = { toNextStep() },
                text = stringResource(id = R.string.next_step),
                modifier = Modifier.align(End),
                enabled = true
            )
        }
    }
}

@Composable
fun FindUserIdVerificationCode(
    toPrevious: () -> Unit,
    toNextStep: () -> Unit
) {
    var verificationCode by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppBar(text = stringResource(id = R.string.find_id)) {
            toPrevious()
        }

        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(36.dp))

            SubTitle3(text = stringResource(id = R.string.verification_email))

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.height(44.dp)
            ) {
                MoizaTextField(
                    value = verificationCode ?: "",
                    onValueChange = { verificationCode = it },
                    modifier = Modifier.fillMaxWidth(0.6f)
                )

                GrayButton(
                    onClick = { /*TODO*/ },
                    text = stringResource(id = R.string.send_verification_code),
                    enabled = !verificationCode.isNullOrEmpty(),
                    modifier = Modifier
                        .padding(start = 7.dp)
                )

            }

            Spacer(modifier = Modifier.height(127.dp))

            NextStepButton(
                onClick = { toNextStep() },
                text = stringResource(id = R.string.next_step),
                modifier = Modifier.align(End),
                enabled = true // TODO("enabledNextStep")
            )
        }
    }
}

@Composable
fun FindUserIdCheck(
    toPrevious: () -> Unit,
    toFindPassword: () -> Unit,
    toSignIn: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppBar(text = stringResource(id = R.string.find_id)) {
            toPrevious()
        }

        Spacer(modifier = Modifier.height(120.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)
                .wrapContentWidth(CenterHorizontally)
        ) {
            Body1(text = "임세현", color = Blue)
            Body1(text = "님의 정보와 일치하는 아이디 입니다.")
        }

        Spacer(modifier = Modifier.height(70.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Gray300), contentAlignment = Center
        ) {
            SubTitle1(text = "sh007100", color = Blue)
        }

        Spacer(modifier = Modifier.height(90.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            NextStepButton(
                onClick = { toFindPassword() },
                text = stringResource(id = R.string.find_password),
                buttonColor = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    backgroundColor = Orange,
                )
            )

            Spacer(modifier = Modifier.width(20.dp))

            NextStepButton(onClick = { toSignIn() }, text = stringResource(id = R.string.to_sign_in))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFindUserIdScreen() {
}