package com.moizaandroid.moiza.ui.post.crerate

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moiza_design.component.AppBar
import com.moiza_design.component.MoizaTextField
import com.moiza_design.component.NumberButton
import com.moiza_design.icon.MoizaIcons
import com.moiza_design.theme.*

@Composable
fun CreatePostScreen(
    onPrevious: () -> Unit
) {

    val verticalScroll = rememberScrollState()
    var title by remember { mutableStateOf<String?>(null) }
    var content by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(verticalScroll)
            .background(Gray200)
    ) {
        AppBar(text = "게시물 작성") {
            onPrevious()
        }

        Spacer(modifier = Modifier.height(10.dp))

        NumberButton(
            text = "임시저장된 글", number = 3, onClick = { /*TODO*/ }, modifier = Modifier
                .align(Alignment.End)
                .padding(end = 16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 13.dp, topEnd = 13.dp)
                )
        ) {
            BasicTextField(
                value = title ?: "",
                onValueChange = { title = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                textStyle = TextStyle(
                    fontFamily = notoSansFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    color = Black
                ),
                decorationBox = { innerTextField ->
                    if (title == null) {
                        SubTitle3(text = "제목을 작성해주세요.", color = Gray400)
                    }
                    innerTextField()
                },
            )

            Divider(color = Gray400, modifier = Modifier.fillMaxWidth(), thickness = 0.5.dp)

            BasicTextField(
                value = content ?: "",
                onValueChange = { content = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(180.dp),
                textStyle = TextStyle(
                    fontFamily = notoSansFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Black
                ),
                decorationBox = { innerTextField ->
                    if (title == null) {
                        Body3(text = "본문을 작성해주세요.", color = Gray400)
                    }
                    innerTextField()
                },
            )

            Divider(color = Gray400, modifier = Modifier.fillMaxWidth(), thickness = 0.5.dp)

            Spacer(modifier = Modifier.height(20.dp))

            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = MoizaIcons.Camera), contentDescription = null)

                    Spacer(modifier = Modifier.width(8.dp))

                    Body4(text = "사진 추가", color = Gray500)

                    Spacer(modifier = Modifier.weight(1f))

                    Body4(text = "0/4", color = Gray500)
                }


            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun PreviewCreatePostScreen() {
    CreatePostScreen({})
}