package com.moizaandroid.moiza.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moiza_design.theme.Blue
import com.moiza_design.theme.Body1
import com.moiza_design.theme.SubTitle1
import com.moiza_design.theme.SubTitle3
import com.moizaandroid.moiza.R
import com.moiza_design.component.AppBar
import com.moiza_design.component.MoizaTextField
import com.moiza_design.component.NextStepButton

@Composable
fun FindPasswordInputId(
    toPrevious: () -> Unit,
    toNextStep: () -> Unit
) {
    var password by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppBar(text = stringResource(id = R.string.find_password)) {
            toPrevious()
        }

        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(36.dp))

            SubTitle3(text = stringResource(id = R.string.input_id))

            Spacer(modifier = Modifier.height(30.dp))

            MoizaTextField(value = password ?: "", onValueChange = { password = it })

            Spacer(modifier = Modifier.height(127.dp))

            NextStepButton(
                onClick = { toNextStep() },
                text = stringResource(id = R.string.next_step),
                modifier = Modifier.align(End),
                enabled = !(password.isNullOrBlank())
            )
        }
    }
}

@Composable
fun FindPasswordVerificationCode(
    toPrevious: () -> Unit,
    toNextStep: () -> Unit
) {
    var verificationCode by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBar(text = stringResource(id = R.string.find_password)) {
            toPrevious()
        }

        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            Body1(text = "회원가입 시 입력하신 이메일")

            Row() {
                Body1(text = "sh007100@naver.com", color = Blue)
                Body1(text = " 로")
            }

            Body1(text = "인증번호가 전송되었습니다.")

            Spacer(modifier = Modifier.height(96.dp))

            MoizaTextField(
                value = verificationCode ?: "",
                onValueChange = { verificationCode = it },
                hint = stringResource(
                    id = R.string.verification_code
                )
            )

            Spacer(modifier = Modifier.height(70.dp))

            NextStepButton(
                onClick = toNextStep,
                text = stringResource(id = R.string.next_step),
                enabled = !(verificationCode.isNullOrEmpty())
            )
        }
    }
}

@Composable
fun FindPasswordResetPassword(
    toPrevious: () -> Unit,
    toNextStep: () -> Unit
) {
    var password by remember { mutableStateOf<String?>(null) }
    var checkPassword by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppBar(text = stringResource(id = R.string.find_password)) {
            toPrevious()
        }

        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(84.dp))

            SubTitle1(text = stringResource(id = R.string.reset_password))

            Spacer(modifier = Modifier.height(70.dp))

            MoizaTextField(
                value = password ?: "",
                onValueChange = { password = it },
                description = stringResource(
                    id = R.string.password_condition
                ),
                isPassword = true
            )
            
            Spacer(modifier = Modifier.height(40.dp))

            MoizaTextField(
                value = checkPassword ?: "",
                onValueChange = { checkPassword = it },
                isPassword = true,
                error = if (password != checkPassword) stringResource(
                    id = R.string.error_password_format
                ) else null
            )
            
            Spacer(modifier = Modifier.height(60.dp))

            NextStepButton(
                onClick = toNextStep,
                text = stringResource(id = R.string.next_step),
                enabled = !(password.isNullOrEmpty()) && password == checkPassword,
                modifier = Modifier.align(End)
            )
        }
    }
}


@Composable
fun FindPasswordFinishReset(
    toPrevious: () -> Unit,
    toSignIn: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppBar(text = stringResource(id = R.string.find_password)) {
            toPrevious()
        }

        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(130.dp))
            
            Image(painter = painterResource(id = R.drawable.ic_all_blue_check), contentDescription = null)
            
            Spacer(modifier = Modifier.height(24.dp))
            
            SubTitle1(text = stringResource(id = R.string.success_find_password))
            
            Spacer(modifier = Modifier.height(80.dp))

            NextStepButton(onClick = toSignIn, text = stringResource(id = R.string.to_sign_in))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFindPasswordScreen() {
    FindPasswordFinishReset({}) {}
}