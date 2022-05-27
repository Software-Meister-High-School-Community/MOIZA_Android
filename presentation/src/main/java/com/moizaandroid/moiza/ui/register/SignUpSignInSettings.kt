package com.moizaandroid.moiza.ui.register

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.extensions.isPasswordFormat
import com.moizaandroid.moiza.ui.component.*
import com.moizaandroid.moiza.ui.theme.Body3
import com.moizaandroid.moiza.ui.theme.Lore1
import com.moizaandroid.moiza.ui.theme.SubTitle1

@Composable
fun SignUpSignInSettings(
    toPrevious: () -> Unit,
    finishSignUp: () -> Unit
) {
    val verticalScroll = rememberScrollState()
    var userId by remember { mutableStateOf<String?>(null) }
    var password by remember { mutableStateOf(String()) }
    var checkPassword by remember { mutableStateOf(String()) }


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AppBar(text = stringResource(id = R.string.sign_up), isSignUp = true) {
            toPrevious()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(verticalScroll)
                .padding(horizontal = 20.dp)
        ) {

            Spacer(modifier = Modifier.height(12.dp))

            StepsProgressBar(
                numberOfSteps = 3,
                currentStep = 3,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(40.dp))

            SubTitle1(text = "로그인 설정")

            Spacer(modifier = Modifier.height(46.dp))


            SignUpSignInSettingsInputUserId(
                userId = userId,
                onUserIdChanged = { userId = it }
            )

            Spacer(modifier = Modifier.height(50.dp))

            SignUpSignInSettingsInputPassword(
                password = password,
                onPasswordChanged = { password = it },
                checkPassword = checkPassword,
                onCheckPasswordChanged = { checkPassword = it }
            )

            Spacer(modifier = Modifier.height(50.dp))

            NextStepButton(
                onClick = finishSignUp,
                text = stringResource(id = R.string.finish_sign_up),
                modifier = Modifier.align(End)
            )
        }
    }
}

@Composable
fun SignUpSignInSettingsInputUserId(
    userId: String?,
    onUserIdChanged: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Body3(text = "아이디")

        Spacer(modifier = Modifier.weight(1f))

        GrayButton(onClick = { /*TODO*/ }, text = "아이디 중복확인")
    }

    MoizaTextField(value = userId ?: "", onValueChange = onUserIdChanged)
}

@Composable
fun SignUpSignInSettingsInputPassword(
    password: String,
    onPasswordChanged: (String) -> Unit,
    checkPassword: String,
    onCheckPasswordChanged: (String) -> Unit
) {
    Body3(text = stringResource(id = R.string.password))

    Spacer(modifier = Modifier.height(15.dp))

    MoizaTextField(
        value = password,
        onValueChange = onPasswordChanged,
        isPassword = true,
        error = if(isPasswordFormat(password = password)) null else stringResource(id = R.string.error_password_format)
    )

    Lore1(
        text = stringResource(id = R.string.password_condition),
        modifier = Modifier.padding(top = 6.dp, start = 3.dp)
    )

    Spacer(modifier = Modifier.height(55.dp))

    Body3(text = stringResource(id = R.string.password_check))

    Spacer(modifier = Modifier.height(15.dp))

    MoizaTextField(
        value = checkPassword,
        onValueChange = onCheckPasswordChanged,
        isPassword = true,
        error = if (password == checkPassword) null else stringResource(id = R.string.error_check_password)
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SignUpSignInSettings({}) {

    }
}