package com.moiza_design.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moiza_design.icon.MoizaIcons
import com.moiza_design.theme.Body3
import com.moiza_design.theme.Gray300

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    text: String,
    isSignUp: Boolean = false,
    onBackButtonClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.Transparent)
        ) {
            Icon(
                modifier = Modifier
                    .padding(16.dp)
                    .size(24.dp)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) {
                        onBackButtonClick()
                    },
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null
            )

            Body3(
                text = text,
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .padding(start = 54.dp),
            )

            if (isSignUp) {
                Image(
                    painter = painterResource(id = MoizaIcons.MoizaLogo),
                    contentDescription = "moiza logo",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 21.dp)
                )
            }
        }
        Divider(
            color = Gray300,
            thickness = 1.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    AppBar(text = "로그인", isSignUp = true, onBackButtonClick = {})
}