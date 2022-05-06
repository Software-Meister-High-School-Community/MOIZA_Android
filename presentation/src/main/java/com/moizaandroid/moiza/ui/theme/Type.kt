package com.moizaandroid.moiza.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.moizaandroid.moiza.R

val notoSansFamily = FontFamily(
    Font(R.font.noto_sans_kr_black, FontWeight.Black),
    Font(R.font.noto_sans_kr_bold, FontWeight.Bold),
    Font(R.font.noto_sans_kr_medium, FontWeight.Medium),
    Font(R.font.noto_sans_kr_regular, FontWeight.Normal),
    Font(R.font.noto_sans_kr_light, FontWeight.Light),
    Font(R.font.noto_sans_kr_thin, FontWeight.Thin)
)

val roboto = FontFamily(
    Font(R.font.rotobo_bold, FontWeight.Bold),
    Font(R.font.rotobo_medium, FontWeight.Medium),
    Font(R.font.rotobo_regular, FontWeight.Normal)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.Normal,
        color = Gray500,
        fontSize = 15.sp
    )
)

val body3 = TextStyle(
    fontFamily = roboto,
    fontWeight = FontWeight.Normal,
    color = Color.White,
    fontSize = 16.sp
)

val body4 = TextStyle(
    fontFamily = roboto,
    fontWeight = FontWeight.Normal,
    color = Gray400,
    fontSize = 12.sp
)