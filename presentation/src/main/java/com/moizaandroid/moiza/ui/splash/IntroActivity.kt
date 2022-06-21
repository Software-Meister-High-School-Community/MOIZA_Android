package com.moizaandroid.moiza.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.UiThread
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moiza_design.component.RoundButton
import com.moiza_design.theme.Blue
import com.moiza_design.theme.MoizaTheme
import com.moiza_design.theme.SubTitle1
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.ActivityIntroBinding
import com.moizaandroid.moiza.ui.base.BaseActivity
import com.moizaandroid.moiza.ui.login.SignInActivity
import com.moizaandroid.moiza.ui.register.SignUpActivity

class IntroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContent {

        }
    }
}

@Composable
fun IntroScreen(
    gotoSignUp: () -> Unit,
) {
    MoizaTheme() {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)) {

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.ic_app_logo), contentDescription = null)

                Spacer(modifier = Modifier.width(20.dp))

                SubTitle1(text = "모이자")
            }

            Spacer(modifier = Modifier.weight(1f))

             Column(modifier = Modifier.wrapContentHeight(Alignment.Bottom)) {
                 RoundButton(text = "회원가입", enabled = true, onClick = gotoSignUp, enabledColor = Blue)
             }
        }
    }
}

@Preview
@Composable
fun PreviewIntroScreen() {
    IntroScreen({})
}