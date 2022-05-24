package com.moizaandroid.moiza.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.moizaandroid.moiza.ui.component.AppBar
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.ui.component.MoizaCheckBox
import com.moizaandroid.moiza.ui.component.YellowButton
import com.moizaandroid.moiza.ui.theme.*

@Composable
fun SignUpAgreedScreen(
    onBackButtonClick: () -> Unit,
    onLoginButtonClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onFindIdClick: () -> Unit,
    onFindPasswordClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        var loginBtnState by rememberSaveable { mutableStateOf(false) }

        AppBar(text = "로그인", onBackButtonClick = onBackButtonClick)
        Spacer(modifier = Modifier.size(56.dp))

        SignInScreenLogo()
        Spacer(modifier = Modifier.size(40.dp))

        SignInScreenEditText(
            buttonOn = { loginBtnState = true },
            buttonOff = { loginBtnState = false }
        )
        Spacer(modifier = Modifier.size(24.dp))

        SignInScreenCheckBox()
        Spacer(modifier = Modifier.size(45.dp))

        YellowButton(
            text = "로그인",
            satisfy = loginBtnState,
            onClick = onLoginButtonClick,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.size(40.dp))

        SignInScreenBottomMenu(
            onSignUpClick = onSignUpClick,
            onFindIdClick = onFindIdClick,
            onFindPasswordClick = onFindPasswordClick
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
            .padding(start = 70.dp, end = 70.dp)
            .height(14.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Body4(text = "회원가입", color = Gray400, modifier = Modifier.clickable { onSignUpClick() })

        Spacer(modifier = Modifier.size(16.dp))

        Divider(
            color = Gray400,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )

        Spacer(modifier = Modifier.size(16.dp))

        Body4(text = "아이디 찾기", color = Gray400, modifier = Modifier.clickable { onFindIdClick() })

        Spacer(modifier = Modifier.size(16.dp))

        Divider(
            color = Gray400,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )

        Spacer(modifier = Modifier.size(16.dp))

        Body4(
            text = "비밀번호 찾기",
            color = Gray400,
            modifier = Modifier.clickable { onFindPasswordClick() })
    }
}

@Composable
fun SignInScreenCheckBox() {
    Row {
        Spacer(modifier = Modifier.size(20.dp))

        var autoLoginState by remember { mutableStateOf(false) }
        MoizaCheckBox(text = "자동 로그인", checked = autoLoginState, onCheckedChange = { autoLoginState = it })

        Spacer(modifier = Modifier.size(30.dp))

        var saveAccountState by remember { mutableStateOf(false) }
        MoizaCheckBox(text = "아이디 저장", checked = saveAccountState, onCheckedChange = { saveAccountState = it })
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
            contentDescription = "logo",
            modifier = Modifier.size(40.dp, 29.dp)
        )

        Spacer(modifier = Modifier.size(16.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_moiza_text),
            contentDescription = "moiza text"
        )
    }
}

@Composable
fun SignInScreenEditText(
    buttonOn: () -> Unit,
    buttonOff: () -> Unit
) {
    var id by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }

    if (id.length >= 6 && pw.length >= 6) buttonOn()
    else buttonOff()

    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ) {
        OutlinedTextField(
            value = id,
            onValueChange = { id = it },
            singleLine = true,
            isError = false,
            textStyle = Typography.body2,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.size(12.dp))
        OutlinedTextField(
            value = pw,
            onValueChange = { pw = it },
            singleLine = true,
            isError = false,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            textStyle = Typography.body2,
            trailingIcon = {
                val image = if (passwordVisible)
                    painterResource(id = R.drawable.ic_pw_visible)
                else painterResource(id = R.drawable.ic_pw_invisible)

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(painter = image, description)
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoizaTheme {
        SignUpAgreedScreen({}, {}, {}, {}, {})
    }
}