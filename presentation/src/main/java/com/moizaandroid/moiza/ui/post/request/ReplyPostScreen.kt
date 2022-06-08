package com.moizaandroid.moiza.ui.post.request

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moiza_design.component.*
import com.moiza_design.icon.MoizaIcons
import com.moiza_design.theme.*
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.ui.post.crerate.DisclosureScope
import com.moizaandroid.moiza.utils.parseBitmap
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ReplayPostScreen(
    onPrevious: () -> Unit,
    onCreatePost: () -> Unit
) {

    val verticalScroll = rememberScrollState()
    var title by remember { mutableStateOf<String?>(null) }
    var content by remember { mutableStateOf<String?>(null) }
    val photos = remember { mutableStateListOf<Bitmap>() }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(verticalScroll)
            .background(Gray200)
    ) {
        AppBar(text = stringResource(id = R.string.write_request_post)) {
            onPrevious()
        }

        Spacer(modifier = Modifier.height(10.dp))

        ReplayPostScreenPostContent(
            title = title,
            onTitleChanged = { title = it },
            content = content,
            onContentChanged = { content = it },
            photos = photos,
            addPhotos = { photos.add(it.parseBitmap(context)) },
            removePhotos = { photos.remove(it) },
            context = context
        )


        Spacer(modifier = Modifier.height(45.dp))

        Row(
            modifier = Modifier.align(Alignment.End),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GrayButton(onClick = {
                DynamicToast.makeSuccess(context, "작성 중인 게시글을 임시로 저장하였습니다.").show()
            }, text = stringResource(id = R.string.temp_save_post), corner_radius = 25.dp)

            NextStepButton(
                onClick = onCreatePost,
                text = stringResource(id = R.string.registering),
                enabled = title != null && content != null
            )
        }

        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun ReplayPostScreenPostContent(
    title: String?,
    onTitleChanged: (String) -> Unit,
    content: String?,
    onContentChanged: (String) -> Unit,
    photos: List<Bitmap>,
    addPhotos: (Uri) -> Unit,
    removePhotos: (Bitmap) -> Unit,
    context: Context
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(13.dp)
            )
    ) {
        BasicTextField(
            value = title ?: "",
            onValueChange = { onTitleChanged(it) },
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
                    SubTitle3(text = stringResource(id = R.string.input_title), color = Gray400)
                }
                innerTextField()
            },
        )

        Divider(color = Gray400, modifier = Modifier.fillMaxWidth(), thickness = 0.5.dp)

        val contentHint = "답변 시 이런 점을 주의해 주세요!\n\n 답변이 등록되면 수정/삭제가 불가합니다.\n 사진 첨부는 4장까지 가능합니다."
        
        BasicTextField(
            value = content ?: "",
            onValueChange = { onContentChanged(it) },
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
                if (content == null) {
                    Body3(text = contentHint, color = Gray400)
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
                Icon(
                    painter = painterResource(id = MoizaIcons.Camera),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(8.dp))

                Body4(text = stringResource(id = R.string.add_photo), color = Gray500)

                Spacer(modifier = Modifier.weight(1f))

                Body4(text = "${photos.size}/4", color = Gray500)
            }
        }

        Spacer(modifier = Modifier.height(23.dp))

        val takePhotoFromAlbumLauncher =
            rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    result.data?.data?.let { uri ->
                        addPhotos(uri)
                    } ?: run {
                        DynamicToast.makeError(context, "사진을 가져오는데 실패했습니다.").show()
                    }
                } else if (result.resultCode != Activity.RESULT_CANCELED) {
                    DynamicToast.makeError(context, "사진을 가져오는데 실패했습니다.").show()
                }
            }

        val takePhotoFromAlbumIntent =
            Intent(
                Intent.ACTION_GET_CONTENT,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            ).apply {
                type = "image/*"
                action = Intent.ACTION_GET_CONTENT
                putExtra(
                    Intent.EXTRA_MIME_TYPES,
                    arrayOf("image/jpeg", "image/png", "image/bmp", "image/webp")
                )
                putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false)
            }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(7.dp),
            modifier = Modifier
                .height(46.dp)
                .padding(horizontal = 20.dp)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .fillMaxHeight()
                        .border(color = Gray400, width = 1.dp)
                        .clickable {
                            if (photos.size < 4) {
                                takePhotoFromAlbumLauncher.launch(takePhotoFromAlbumIntent)
                            } else {
                                DynamicToast
                                    .makeError(context, "사진을 4장 이상 등록할 수 없습니다.")
                                    .show()
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = MoizaIcons.CreateImage),
                        contentDescription = null
                    )
                }
            }

            items(photos) { photo ->
                Box(
                    contentAlignment = Alignment.CenterEnd
                ) {
                    GlideImage(
                        imageModel = photo, modifier = Modifier
                            .fillMaxHeight()
                            .width(80.dp)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(color = HalfDark)
                            .width(40.dp)
                            .clickable { removePhotos(photo) },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = MoizaIcons.WhiteClose),
                            contentDescription = null
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Preview(showBackground = true, heightDp = 1500)
@Composable
fun PreviewCreatePostScreen() {
    ReplayPostScreen({}) {}
}