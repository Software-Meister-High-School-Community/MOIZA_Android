package com.moizaandroid.moiza.ui.register

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.ui.component.*
import com.moizaandroid.moiza.ui.theme.*

@Composable
fun SignUpInputStudentScreen(
    toPrevious: () -> Unit,
    toNextStep: () -> Unit
) {
    val verticalScroll = rememberScrollState()

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
                currentStep = 2,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(25.dp))

            SubTitle1(
                text = stringResource(id = R.string.input_info),
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(43.dp))

            Body3(text = stringResource(id = R.string.sortation))

            Spacer(modifier = Modifier.height(15.dp))

            var graduate by remember { mutableStateOf(false) }
            var ungraduate by remember { mutableStateOf(false) }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                MoizaCheckBox(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    text = stringResource(id = R.string.ungraduate),
                    checked = ungraduate,
                    onCheckedChange = {
                        ungraduate = it
                        graduate = !it
                    }
                )
                MoizaCheckBox(
                    text = stringResource(id = R.string.graduate),
                    checked = graduate,
                    onCheckedChange = {
                        graduate = it
                        ungraduate = !it
                    }
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Body3(text = stringResource(id = R.string.name))

            Spacer(modifier = Modifier.height(15.dp))

            var name by remember { mutableStateOf(String()) }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
            ) {
                MoizaTextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth(0.7f)
                )

                Spacer(modifier = Modifier.width(10.dp))

                var isMale by remember { mutableStateOf(true) }

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(44.dp)
                        .border(
                            shape = RoundedCornerShape(topStart = 1.dp, bottomStart = 1.dp),
                            width = 1.dp,
                            color = Gray300
                        )
                        .background(color = if (isMale) Orange else Color.White)
                        .clickable {
                            isMale = !isMale
                        }
                ) {
                    Body3(
                        text = stringResource(id = R.string.male), modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Center)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(44.dp)
                        .border(
                            shape = RoundedCornerShape(topEnd = 1.dp, bottomEnd = 1.dp),
                            width = 1.dp,
                            color = Gray300
                        )

                        .background(if (!isMale) Orange else Color.White)
                        .clickable {
                            isMale = !isMale
                        }
                ) {
                    Body3(
                        text = stringResource(id = R.string.female), modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Center)
                    )
                }
            }

            Spacer(modifier = Modifier.height(50.dp))

            Body3(text = stringResource(id = R.string.yyyyddmm))

            Spacer(modifier = Modifier.height(15.dp))

            var birthDay by remember { mutableStateOf(String()) }

            MoizaTextField(value = birthDay, onValueChange = { birthDay = it }, keyboardType = KeyboardType.Number)

            Spacer(modifier = Modifier.height(50.dp))

            Body3(text = stringResource(id = R.string.select_school))

            Spacer(modifier = Modifier.height(15.dp))

            val schoolName = listOf(
                Schools.BSM.schoolName,
                Schools.DGSM.schoolName,
                Schools.DSM.schoolName,
                Schools.GSM.schoolName,
                Schools.MIRIN.schoolName
            )

            var school: String by remember { mutableStateOf(String())}

            val schoolEmail = when (school) {
                Schools.BSM.schoolName -> Schools.BSM.schoolEmail
                Schools.DGSM.schoolName -> Schools.DGSM.schoolEmail
                Schools.DSM.schoolName -> Schools.DSM.schoolEmail
                Schools.GSM.schoolName -> Schools.GSM.schoolEmail
                Schools.MIRIN.schoolName -> Schools.MIRIN.schoolEmail
                else -> ""
            }

            MoizaVerticalMenus(onMenuClicked = { school = it }, menus = schoolName)

            Spacer(modifier = Modifier.height(32.dp))

            Body3(text = stringResource(id = R.string.school_email))

            Spacer(modifier = Modifier.height(15.dp))

            var userId by remember { mutableStateOf(String()) }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                MoizaTextField(
                    value = userId,
                    onValueChange = { userId = it },
                    modifier = Modifier.fillMaxWidth(0.35f)
                )

                Spacer(modifier = Modifier.weight(0.5f))

                Body3(text = "@ $schoolEmail")

                Spacer(modifier = Modifier.weight(0.5f))

                OutlinedButton(
                    onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                        backgroundColor = Gray200,
                        contentColor = Gray600
                    ),
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Body3(text = stringResource(id = R.string.request_verity))
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Body3(text = stringResource(id = R.string.verification_code))

            Spacer(modifier = Modifier.height(15.dp))

            var verificationCode by remember { mutableStateOf(String()) }
            MoizaTextField(value = verificationCode, onValueChange = { verificationCode = it })

            Spacer(Modifier.height(75.dp))

            Button(
                onClick = toNextStep,
                modifier = Modifier
                    .size(88.dp, 36.dp)
                    .align(End),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    backgroundColor = Blue
                )
            ) {
                Text(
                    text = stringResource(id = R.string.next_step),
                    style = TextStyle(
                        fontFamily = roboto,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}


@Preview(
    showBackground = true,
    heightDp = 1500
)
@Composable
fun PreviewSignUpInputStudentScreen() {
    SignUpInputStudentScreen({}) {}
}