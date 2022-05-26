package com.moizaandroid.moiza.ui.register

import android.app.DatePickerDialog
import android.widget.DatePicker
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
import androidx.compose.ui.platform.LocalContext
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
import java.util.*

@Composable
fun SignUpInputStudentScreen(
    toPrevious: () -> Unit,
    toNextStep: () -> Unit
) {
    val verticalScroll = rememberScrollState()

    var isGraduated by remember { mutableStateOf<Boolean?>(null) }

    var name by remember { mutableStateOf(String()) }

    var isMale by remember { mutableStateOf(true) }

    var birthDay by remember { mutableStateOf<Int?>(null) }

    var school by remember { mutableStateOf<Schools?>(null) }

    var userId by remember { mutableStateOf(String()) }

    var verificationCode by remember { mutableStateOf(String()) }

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


            SignUpInputStudentGraduateCheckBox(
                isGraduated = isGraduated,
                doOnGraduateStudentClick = {
                    isGraduated = true
                },
                doOnNotGraduateStudentClick = {
                    isGraduated = false
                }
            )

            Spacer(modifier = Modifier.height(50.dp))

            SignUpInputStudentName(
                name = name,
                onNameChanged = { name = it },
                isMale = isMale,
                onSexChanged = { isMale = it }
            )

            Spacer(modifier = Modifier.height(50.dp))

            SignUpInputStudentBirthDay(
                birthDay = birthDay,
                onBirthDayChanged = { birthDay = it }
            )

            Spacer(modifier = Modifier.height(50.dp))

            SignUpInputStudentSelectSchool(
                school = school,
                onSchoolChanged = { school = it }
            )

            Spacer(modifier = Modifier.height(32.dp))

            SignUpInputStudentSchoolEmail(
                userId = userId,
                onUserIdChanged = { userId = it },
                school = school
            )

            Spacer(modifier = Modifier.height(24.dp))

            SignUpInputStudentVerificationCode(
                verificationCode = verificationCode,
                onVerificationCodeChanged = { verificationCode = it }
            )

            Spacer(Modifier.height(75.dp))

            NextStepButton(
                onClick = toNextStep,
                modifier = Modifier.align(End),
                text = stringResource(id = R.string.next_step)
            )

            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

@Composable
fun SignUpInputStudentVerificationCode(
    verificationCode: String,
    onVerificationCodeChanged: (String) -> Unit
) {
    SubTitle4(text = stringResource(id = R.string.verification_code))

    Spacer(modifier = Modifier.height(15.dp))

    MoizaTextField(value = verificationCode, onValueChange = { onVerificationCodeChanged(it) })

}

@Composable
fun SignUpInputStudentSchoolEmail(
    userId: String,
    onUserIdChanged: (String) -> Unit,
    school: Schools?
) {

    SubTitle4(text = stringResource(id = R.string.school_email))

    Spacer(modifier = Modifier.height(15.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MoizaTextField(
            value = userId,
            onValueChange = { onUserIdChanged(it) },
            modifier = Modifier.fillMaxWidth(0.35f)
        )

        Spacer(modifier = Modifier.weight(0.5f))

        Body3(text = "@ ${school?.schoolEmail ?: ""}")

        Spacer(modifier = Modifier.weight(0.5f))

        GrayButton(
            onClick = {},
            text = "인증 요청",
            modifier = Modifier.fillMaxHeight()
        )
    }
}

@Composable
fun SignUpInputStudentSelectSchool(
    school: Schools?,
    onSchoolChanged: (Schools) -> Unit
) {
    SubTitle4(text = stringResource(id = R.string.select_school))

    Spacer(modifier = Modifier.height(15.dp))

    MoizaVerticalMenus(
        onMenuClicked = { onSchoolChanged(it) },
        menus = Schools.values().toList(),
        selectedSchool = school?.schoolName ?: ""
    )
}

@Composable
fun SignUpInputStudentBirthDay(
    birthDay: Int?,
    onBirthDayChanged: (Int) -> Unit
) {

    val mContext = LocalContext.current

    val mYear: Int
    val mMonth: Int
    val mDay: Int

    val mCalendar = Calendar.getInstance()

    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            val month = String.format("%04d%02d%02d", mYear, mMonth+1, mDayOfMonth)
            onBirthDayChanged(month.toInt())
        }, mYear, mMonth, mDay
    )

    SubTitle4(text = stringResource(id = R.string.yyyyddmm))

    Spacer(modifier = Modifier.height(15.dp))

    TextFieldButton(
        onClick = { mDatePickerDialog.show() },
        text = "${birthDay ?: ""}"
    )
}

@Composable
fun SignUpInputStudentGraduateCheckBox(
    isGraduated: Boolean?,
    doOnGraduateStudentClick: (Boolean) -> Unit,
    doOnNotGraduateStudentClick: (Boolean) -> Unit
) {
    SubTitle4(text = stringResource(id = R.string.sortation))

    Spacer(modifier = Modifier.height(15.dp))

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        MoizaCheckBox(
            modifier = Modifier.fillMaxWidth(0.5f),
            text = stringResource(id = R.string.ungraduate),
            checked = isGraduated == false,
            onCheckedChange = doOnNotGraduateStudentClick
        )
        MoizaCheckBox(
            text = stringResource(id = R.string.graduate),
            checked = isGraduated == true,
            onCheckedChange = doOnGraduateStudentClick
        )
    }
}

@Composable
fun SignUpInputStudentName(
    name: String,
    onNameChanged: (String) -> Unit,
    isMale: Boolean,
    onSexChanged: (Boolean) -> Unit
) {
    SubTitle4(text = stringResource(id = R.string.name))

    Spacer(modifier = Modifier.height(15.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
    ) {
        MoizaTextField(
            value = name,
            onValueChange = { onNameChanged(it) },
            modifier = Modifier.fillMaxWidth(0.7f)
        )

        Spacer(modifier = Modifier.width(10.dp))

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
                    onSexChanged(true)
                }
        ) {
            Body3(
                text = stringResource(id = R.string.male), modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Center), color = if (isMale) Color.White else Color.Black
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
                    onSexChanged(false)
                }
        ) {
            Body3(
                text = stringResource(id = R.string.female), modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Center),
                color = if (isMale) Color.Black else Color.White
            )
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