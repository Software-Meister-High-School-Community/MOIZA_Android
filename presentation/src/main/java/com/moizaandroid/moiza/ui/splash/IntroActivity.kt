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
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIconDefaults.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.moiza_design.component.MoizaOutlineButton
import com.moiza_design.component.RoundButton
import com.moiza_design.theme.Blue
import com.moiza_design.theme.Gray500
import com.moiza_design.theme.MoizaTheme
import com.moiza_design.theme.SubTitle1
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.ui.login.SignInActivity
import com.moizaandroid.moiza.ui.register.SignUpActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            IntroScreen(gotoSignUp = {
                startActivity(Intent(this, SignUpActivity::class.java))
            }) {
                startActivity(Intent(this, SignInActivity::class.java))
            }
        }
    }
}

@Composable
fun IntroScreen(
    gotoSignUp: () -> Unit,
    gotoSignIn: () -> Unit
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

                Spacer(modifier = Modifier.width(12.dp))

                SubTitle1(text = "모이자", fontWeight = FontWeight.Black)
            }

            Spacer(modifier = Modifier.weight(1f))

             Column(modifier = Modifier.wrapContentHeight(Alignment.Bottom)) {
                 RoundButton(text = "회원가입", textColor = Color.White, enabled = true, onClick = gotoSignUp, enabledColor = Blue, modifier = Modifier.height(48.dp))

                 Spacer(modifier = Modifier.height(8.dp))

                 MoizaOutlineButton(text = "로그인", textColor = Gray500, modifeir = Modifier
                     .fillMaxWidth()
                     .height(48.dp)) {
                     gotoSignIn()
                 }
                 
                 Spacer(modifier = Modifier.height(56.dp))
             }
        }
    }
}

@Preview
@Composable
fun PreviewIntroScreen() {
    IntroScreen({}) {}
}