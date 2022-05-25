package com.moizaandroid.moiza.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.ui.register.Schools
import com.moizaandroid.moiza.ui.theme.Body3
import com.moizaandroid.moiza.ui.theme.Gray300
import com.moizaandroid.moiza.ui.theme.Gray500
import com.moizaandroid.moiza.ui.theme.Orange

@Composable
fun MoizaVerticalMenus(
    modifier: Modifier = Modifier,
    onMenuClicked: ((Schools) -> Unit)?,
    selectedSchool: String,
    menus: List<Schools>
) {
    Column {
        for (element in menus) {
            MoizaVerticalMenu(
                modifier = modifier.padding(bottom = 5.dp),
                school = element,
                selectedSchool = selectedSchool,
                onMenuClicked = onMenuClicked
            )
        }
    }
}

@Composable
fun MoizaVerticalMenu(
    modifier: Modifier = Modifier,
    school: Schools,
    selectedSchool: String,
    onMenuClicked: ((Schools) -> Unit)?
) {
    val menu = school.schoolName
    if (selectedSchool == menu) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(44.dp)
                .background(color = Orange, shape = RoundedCornerShape(5.dp))
                .border(
                    shape = RoundedCornerShape(5.dp),
                    color = Gray300,
                    width = 1.dp
                )
                .clickable {
                    if (onMenuClicked != null) {
                        onMenuClicked(school)
                    }
                }
        ) {
            Body3(
                text = menu,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 14.dp)
                    .fillMaxHeight()
                    .wrapContentHeight(CenterVertically)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_checked),
                contentDescription = "checked icon",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentWidth(End)
                    .wrapContentHeight(CenterVertically)
                    .padding(end = 16.dp)
            )
        }
    } else {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(44.dp)
                .background(
                    shape = RoundedCornerShape(5.dp),
                    color = Color.Transparent
                )
                .border(
                    shape = RoundedCornerShape(5.dp),
                    color = Gray300,
                    width = 1.dp
                )
                .clickable {
                    if (onMenuClicked != null) {
                        onMenuClicked(school)
                    }
                }
        ) {
            Body3(
                text = menu,
                color = Gray500,
                modifier = Modifier
                    .padding(start = 14.dp)
                    .fillMaxHeight()
                    .wrapContentHeight(CenterVertically)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMoizaVerticalMenu() {
    MoizaVerticalMenus(
        menus = listOf(Schools.DSM, Schools.MIRIN),
        onMenuClicked = { it },
        selectedSchool = "null"
    )
}