package com.moizaandroid.moiza.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.moiza_design.component.AppBar
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moiza_design.theme.Body4
import com.moiza_design.theme.Gray400
import com.moiza_design.theme.MoizaTheme
import com.moizaandroid.moiza.R
import com.moiza_design.component.MoizaCheckBox
import com.moiza_design.component.MoizaTextField
import com.moiza_design.component.YellowButton

@Composable
fun SignInScreen(
    toPrevious: () -> Unit,
    doSignIn: () -> Unit,
    toSignUp: () -> Unit,
    toFindId: () -> Unit,
    toFindPassword: () -> Unit
) {

    var userId by remember { mutableStateOf(String()) }
    var password by remember { mutableStateOf(String()) }

    var autoLoginState by remember { mutableStateOf(false) }
    var saveAccountState by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {

        AppBar(text = stringResource(id = R.string.sign_in)) {
            toPrevious()
        }

        Spacer(modifier = Modifier.height(56.dp))

        SignInScreenLogo()

        Spacer(modifier = Modifier.height(40.dp))

        SignInScreenEditText(
            userId = userId,
            onUserIdChanged = { userId = it },
            password = password,
            onPasswordChanged = { password = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

        SignInScreenCheckBox(
            autoLoginState = autoLoginState,
            saveAccountState = saveAccountState,
            onAutoLoginStateChanged = { autoLoginState = it },
            onSaveAccountStateChanged = { saveAccountState = it }
        )

        Spacer(modifier = Modifier.height(45.dp))

        YellowButton(
            text = stringResource(id = R.string.sign_in),
            satisfy = userId.length > 5 && password.length > 5,
            onClick = doSignIn,
        )

        Spacer(modifier = Modifier.height(40.dp))

        SignInScreenBottomMenu(
            onSignUpClick = toSignUp,
            onFindIdClick = toFindId,
            onFindPasswordClick = toFindPassword
        )
    }
}

@Composable
fun SignInScreenBottomMenu(
    onSignUpClick: () -> Unit,
    onFindIdClick: () -> Unit,
    onFindPasswordClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(14.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Body4(text = stringResource(id = R.string.sign_up), color = Gray400, modifier = Modifier.clickable { onSignUpClick() })

        Spacer(modifier = Modifier.width(16.dp))

        Divider(
            color = Gray400,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Body4(text = stringResource(id = R.string.find_id), color = Gray400, modifier = Modifier.clickable { onFindIdClick() })

        Spacer(modifier = Modifier.width(16.dp))

        Divider(
            color = Gray400,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Body4(
            text = stringResource(id = R.string.find_password),
            color = Gray400,
            modifier = Modifier.clickable { onFindPasswordClick() })
    }
}

@Composable
fun SignInScreenCheckBox(
    autoLoginState: Boolean,
    onAutoLoginStateChanged: (Boolean) -> Unit,
    saveAccountState: Boolean,
    onSaveAccountStateChanged: (Boolean) -> Unit
) {
    Row {
        MoizaCheckBox(text = stringResource(id = R.string.auto_sign_in), checked = autoLoginState, onCheckedChange = {
            onAutoLoginStateChanged(it)
        })

        Spacer(modifier = Modifier.width(30.dp))

        MoizaCheckBox(text = stringResource(id = R.string.save_id), checked = saveAccountState, onCheckedChange = { onSaveAccountStateChanged(it) })
    }
}

@Composable
fun SignInScreenLogo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_moiza_logo),
            contentDescription = null,
            modifier = Modifier.size(40.dp, 29.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_moiza_text),
            contentDescription = null
        )
    }
}

@Composable
fun SignInScreenEditText(
    userId: String?,
    onUserIdChanged: (String) -> Unit,
    password: String?,
    onPasswordChanged: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        MoizaTextField(value = userId ?: "", onValueChange = { onUserIdChanged(it) }, hint = "아이디")

        Spacer(modifier = Modifier.height(12.dp))

        MoizaTextField(
            value = password ?: "",
            onValueChange = { onPasswordChanged(it) },
            hint = "비밀번호",
            isPassword = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoizaTheme {
        SignInScreen({}, {}, {}, {}, {})
    }
}