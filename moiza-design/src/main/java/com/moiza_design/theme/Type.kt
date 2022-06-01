package com.moizaandroid.moiza.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.moiza_design.theme.Gray400
import com.moiza_design.theme.Gray500
import com.moiza_design.theme.roboto

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